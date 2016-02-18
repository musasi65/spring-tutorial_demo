/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etagtest;

import etagtest.Etc01;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 62552
 */
public interface Etc01Repository {

    public List<Etc01> get5minsdata(Timestamp forlast5minstime,int end_site);

    public Etc01 get2hoursdata(Timestamp forlast2hourstime,int start_site, String epc);

}
