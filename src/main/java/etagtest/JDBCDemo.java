package etagtest;

import demo.backend.jdbc.*;
import java.text.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Timestamp;

import static java.util.Collections.list;
import java.util.Date;
import java.util.List;

public class JDBCDemo {

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
               

		// insert
//		try {
//		 Global g = new Global();
//		 g.setUid("123456789");
//		 g.setBelong("192.168.0.10");
//		 gr.addGlobal(g);
//		 } catch (Exception ex) {
//		 ex.printStackTrace();
//		 System.out.println("duplicate key!");
//		 }

     List<Route_ID> RouteIDlist=routeidinfo.getRouteID();
        System.out.println(RouteIDlist.size());
                
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");  
        String testtime="2016-02-02 14:05:00.000";


        Date date= new Date();
        long time = date.getTime();
        Timestamp testtimenow = new Timestamp(time);        
        Timestamp forlast2hour = new Timestamp(time);
        Timestamp forlast5mins =   new Timestamp(time);
        
        
        //Calendar testtimerange = Calendar.getInstance();    
        testtimenow.setTime(sdf.parse(testtime).getTime());
        forlast2hour.setTime(sdf.parse(testtime).getTime());        
        forlast5mins.setTime(sdf.parse(testtime).getTime());
      

        forlast2hour.setTime(forlast2hour.getTime()-2*60*60*1000);
        //forlast2hour.add(Calander.HOUR_OF_DAY,-2);         
        forlast5mins.setTime(forlast5mins.getTime()-5*60*1000);
        
//          String forlast2hour =sdf.format(testtimeforlast2hour.getTime());   
//         String forlast5mins =sdf.format(testtimeforlast5mins.getTime());  
             

         
//        
//                        List<Global> list = gr.findAll();
//        // select
//        Route_ID Route_IDinfo = routeidinfo.get
//                
//                List<Etc01>  etc5minsdata= etc01data.get5minsdata(null),
//                List<Etc01>  etc2hoursdata= etc01data.get2hoursdata(null),
//                
//
//                   RealtimeTraveltime     
        
        
                   List<Etc01> datalist5mins=etc01data.get5minsdata(forlast5mins);
                   List<Etc01> datalist2hours=etc01data.get2hoursdata(forlast2hour);   
                   System.out.println(datalist5mins.size());
                   System.out.println(datalist2hours.size());
                   
                   
                   
//                   Timestamp createtime=testtimenow ;
//                   RealtimeTraveltime testdata =new RealtimeTraveltime();
//                    testdata.setCreatetime(createtime);
//                    testdata.setFlownum(100);
//                    testdata.setRoute_id(1);
//                    testdata.setTraveltime(100);
//                    realtimetraveltimetdata.addRealtimeTraveltime(testdata);
                    
                   
                   
//        Global g2 = gr.findOne("123456");

        
        
    }

}
