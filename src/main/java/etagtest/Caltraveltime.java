/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etagtest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Hsu
 */
public class Caltraveltime {

    public static void main(String[] args) throws ParseException {
        @SuppressWarnings("resource")
        // ApplicationContext ctx = new ClassPathXmlApplicationContext(
        // "datasource.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                JDBCConfig.class);
        // BasicDataSource bds = ctx.getBean(BasicDataSource.class);
        // System.out.println(bds);
        // JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);
        // System.out.println(jt);
        RouteIDRepository routeidinfo = ctx.getBean(RouteIDRepository.class);
        System.out.println(routeidinfo);
        Etc01Repository etc01data = ctx.getBean(Etc01Repository.class);
        System.out.println(etc01data);
        RealtimeTraveltimeRepository realtimetraveltimetdata = ctx.getBean(RealtimeTraveltimeRepository.class);
        System.out.println(realtimetraveltimetdata);

        List<Route_ID> RouteIDlist = routeidinfo.getRouteID();
        System.out.println(RouteIDlist.size());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String testtime = "2016-02-02 14:05:00.000";

        Date date = new Date();
        long time = date.getTime();
        Timestamp testtimenow = new Timestamp(time);
        Timestamp forlast2hour = new Timestamp(time);
        Timestamp forlast5mins = new Timestamp(time);

        //Calendar testtimerange = Calendar.getInstance();    
        testtimenow.setTime(sdf.parse(testtime).getTime());
        forlast2hour.setTime(sdf.parse(testtime).getTime());
        forlast5mins.setTime(sdf.parse(testtime).getTime());

        forlast2hour.setTime(forlast2hour.getTime() - 2 * 60 * 60 * 1000);
        //forlast2hour.add(Calander.HOUR_OF_DAY,-2);         
        forlast5mins.setTime(forlast5mins.getTime() - 5 * 60 * 1000);

        Caltraveltime test = new Caltraveltime();
        test.caltraveltime(etc01data, realtimetraveltimetdata, RouteIDlist, testtimenow, forlast5mins, forlast2hour);

    }

    public void caltraveltime(Etc01Repository etc01data, RealtimeTraveltimeRepository realtimetraveltimetdata, List<Route_ID> path_id, Timestamp timenow, Timestamp last5mins, Timestamp last2hors) {

        for (Route_ID route : path_id) {
            int num = 0;
            int flownum = 0;
            int route_id = route.getRoute_id();
            int start_site = route.getStartsite();
            int end_site = route.getEndsite();
            int totalNum5 = 0;
            ArrayList<Double> traveltime_list = new ArrayList<Double>();

            List<Etc01> last5minsdata = etc01data.get5minsdata(last5mins, end_site);
            if (last5minsdata.isEmpty()) {

                RealtimeTraveltime createdata = new RealtimeTraveltime();

                createdata.setCreatetime(timenow);
                createdata.setRoute_id(route_id);
                createdata.setFlownum(0);
                createdata.setTraveltime(100000);
                System.out.println("insert" + route_id);

                realtimetraveltimetdata.addRealtimeTraveltime(createdata);
            } else {
                for (Etc01 fiveminsdata : last5minsdata) {

                    long end_time = fiveminsdata.getTagtime().getTime();
                    String epc = fiveminsdata.getEpc();

                    Etc01 last2hoursdata = etc01data.get2hoursdata(last2hors, start_site, epc);
                    if (last2hoursdata == null) {
                        num++;

                    } else {
                        flownum++;
                        num++;
                        long start_time = last2hoursdata.getTagtime().getTime();
                        double single_traveltime = (end_time - start_time) / 1000;
                        traveltime_list.add(single_traveltime);
                    }

                    if (num == last5minsdata.size()) {

                        if (traveltime_list.size() == 0) {
                            RealtimeTraveltime createdata = new RealtimeTraveltime();
                            createdata.setCreatetime(timenow);
                            createdata.setRoute_id(route_id);
                            createdata.setFlownum(flownum);
                            createdata.setTraveltime(10000);
                            realtimetraveltimetdata.addRealtimeTraveltime(createdata);
                            System.out.println("insert" + route_id);

                        } else {
                            ListIterator<Double> num_list = traveltime_list.listIterator();

                            while (num_list.hasNext()) {
                                totalNum5 += num_list.next();
                            }
                            int mean_traveltime = totalNum5 / (traveltime_list.size());
                            RealtimeTraveltime createdata = new RealtimeTraveltime();
                            createdata.setCreatetime(timenow);
                            createdata.setRoute_id(route_id);
                            createdata.setFlownum(flownum);
                            createdata.setTraveltime(mean_traveltime);
                            realtimetraveltimetdata.addRealtimeTraveltime(createdata);
                            System.out.println("insert" + route_id);
                        }
                    }
                }

            }
        }
    }

}
