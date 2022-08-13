package com.softserve.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {
    private String city;
    private String street;
    private String zipcode;
    private String suite;
    @JsonProperty(value = "geo")
    private GeoLocationDTO geoLocationDTO;



    public String getCity() {
        return city;
    }

    public AddressDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDTO setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public AddressDTO setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getSuite() {
        return suite;
    }

    public AddressDTO setSuite(String suite) {
        this.suite = suite;
        return this;
    }

    public GeoLocationDTO getGeoLocationDTO() {
        return geoLocationDTO;
    }

    public AddressDTO setGeoLocationDTO(GeoLocationDTO geoLocationDTO) {
        this.geoLocationDTO = geoLocationDTO;
        return this;
    }
}
