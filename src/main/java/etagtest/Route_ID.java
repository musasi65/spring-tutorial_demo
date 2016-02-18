/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etagtest;

import java.util.Date;

/**
 *
 * @author 62552
 */
public class Route_ID {

    private int route_id;
    private String road_name;
    private String direction;
    private int start_site_id;
    private int end_site_id;
    private int dist;
    private String type;

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {

        this.route_id = route_id;
    }

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {

        this.road_name = road_name;
    }

    public String getDirection() {

        return direction;
    }

    public void setDirection(String direction) {

        this.direction = direction;
    }

    public int getStartsite() {

        return start_site_id;
    }

    public void setStartsite(int start_site_id) {

        this.start_site_id = start_site_id;
    }

    public int getEndsite() {

        return end_site_id;
    }

    public void setEndsite(int end_site_id) {

        this.end_site_id = end_site_id;
    }

    public int setDist() {
        return dist;
    }

    public void setDist(int dist) {

        this.dist = dist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

}
