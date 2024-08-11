package com.example.optiroute;

public class Route {
    private int transportIcon;
    private String routeInfo;
    private String travelTime;

    public Route(int transportIcon, String routeInfo, String travelTime) {
        this.transportIcon = transportIcon;
        this.routeInfo = routeInfo;
        this.travelTime = travelTime;
    }

    public int getTransportIcon() {
        return transportIcon;
    }

    public String getRouteInfo() {
        return routeInfo;
    }

    public String getTravelTime() {
        return travelTime;
    }
}