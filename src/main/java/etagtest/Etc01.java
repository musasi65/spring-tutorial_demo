/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etagtest;

import java.sql.Timestamp;
import java.util.Date;


/**
 *
 * @author 62552
 */
public class Etc01 {

    private int key_id;
    private String epc;
    private String tid;
    private int station;
    private int lane;
    private int vehicles;
    private String direction;
    private Timestamp stag_time;
    private Timestamp system_time;

//        
//    	private String uid;
//	private String belong;
    public int getKey_id() {

        return key_id;
    }

    public void setKey_id(int key_id) {

        this.key_id = key_id;
    }

    public String getEpc() {

        return epc;
    }

    public void setEpc(String epc) {

        this.epc = epc;
    }

    public String getTid() {

        return tid;
    }

    public void setTid(String tid) {

        this.tid = tid;
    }

    public int getLane() {

        return lane;
    }

    public void setLane(int lane) {

        this.lane = lane;
    }

    public int getVehicles() {

        return vehicles;
    }

    public void setVehicles(int vehicles) {

        this.vehicles = vehicles;
    }

    public int getStation() {

        return station;
    }

    public void setStation(int station) {

        this.station = station;
    }

    public String getDirection() {

        return direction;
    }

    public void setDirection(String direction) {

        this.direction = direction;
    }

    public Date getTagtime() {

        return stag_time;
    }

    public void setTagtime(Timestamp stag_time) {

        this.stag_time = stag_time;
    }

}
