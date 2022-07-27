package com.softserve.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private String city;
    private String street;
    private String zipcode;
    private String suite;
    @JsonProperty(value = "geo")
    private GeoLocation geoLocation;

    public Address() {
        super();
    }

    public Address(String city, String street, String zipcode, String suite, GeoLocation geoLocation) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.suite = suite;
        this.geoLocation = geoLocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }
}
