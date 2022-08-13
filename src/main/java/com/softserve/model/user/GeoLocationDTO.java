package com.softserve.model.user;

public class GeoLocationDTO {
    private String lat;
    private String lng;

    public GeoLocationDTO() {
        super();
    }


    public String getLat() {
        return lat;
    }

    public GeoLocationDTO setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getLng() {
        return lng;
    }

    public GeoLocationDTO setLng(String lng) {
        this.lng = lng;
        return this;
    }
}
