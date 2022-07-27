package com.softserve.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    @JsonProperty(value = "address")
    private Address userAddress;
    @JsonProperty(value = "company")
    private Company userCompany;

    public static User createBasicUser(){
        User user = new User(
                11,
                "Alex", "Cherry",
                "Alexcherry@mail.com",
                "3928-28-11-1",
                "cherry.net",
                new Address("London", "St. Green", "3782", "392",
                        new GeoLocation("-1.2334", "2.283")),
                new Company("Bull Co", "Be brave", "JP")
        );
        return user;
    }

    public User() {
        super();
    }

    public User(Integer id, String name, String username, String email, String phone, String website, Address userAddress, Company userCompany) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.username = username;
        this.userAddress = userAddress;
        this.userCompany = userCompany;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public Company getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(Company userCompany) {
        this.userCompany = userCompany;
    }
}
