package com.softserve.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UserDTO {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    @JsonProperty(value = "address")
    private AddressDTO userAddressDTO;
    @JsonProperty(value = "company")
    private CompanyDTO userCompanyDTO;


    @JsonIgnore
    public static UserDTO createBasicUser(){
        UserDTO userDTO = new UserDTO()
                .setName("Oleksii").setUsername("Cheezy")
                .setEmail("OleksiiCheezy@gmail.com")
                .setPhone("3928-28-11-2")
                .setWebsite("alexch.com")
                .setUserAddress(new AddressDTO().setCity("Lviv").setStreet("st. Kulparkivs").setSuite("123").setZipcode("182121-1")
                        .setGeoLocationDTO(new GeoLocationDTO().setLng("1.232").setLat("2.243")))
                .setUserCompany(new CompanyDTO().setCompanyName("Bulls").setBs("BS v.").setCatchPhrase("My catch pharase"));
        return userDTO;
    }

//    public UserDTO() {
//        super();
//    }
//
//    public UserDTO(Integer id, String name, String username, String email, String phone, String website, AddressDTO userAddressDTO, CompanyDTO userCompanyDTO) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.website = website;
//        this.username = username;
//        this.userAddressDTO = userAddressDTO;
//        this.userCompanyDTO = userCompanyDTO;
//    }

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public UserDTO setWebsite(String website) {
        this.website = website;
        return this;
    }

    public AddressDTO getUserAddress() {
        return userAddressDTO;
    }

    public UserDTO setUserAddress(AddressDTO userAddressDTO) {
        this.userAddressDTO = userAddressDTO;
        return this;
    }

    public CompanyDTO getUserCompany() {
        return userCompanyDTO;
    }

    public UserDTO setUserCompany(CompanyDTO userCompanyDTO) {
        this.userCompanyDTO = userCompanyDTO;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        return new EqualsBuilder().append(id, userDTO.id).append(name, userDTO.name).append(username, userDTO.username).append(email, userDTO.email).append(phone, userDTO.phone).append(website, userDTO.website).append(userAddressDTO, userDTO.userAddressDTO).append(userCompanyDTO, userDTO.userCompanyDTO).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(username).append(email).append(phone).append(website).append(userAddressDTO).append(userCompanyDTO).toHashCode();
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", userCityDTO=' " + userAddressDTO.getCity() + '\'' +
                ", userStreetDTO=' " + userAddressDTO.getStreet() + '\'' +
                ", userSuiteDTO=' " + userAddressDTO.getSuite() + '\'' +
                ", userZipCodeDTO=' " + userAddressDTO.getZipcode() + '\'' +
                ", userAddressGeoLatDTO=' " + userAddressDTO.getGeoLocationDTO().getLat() + '\'' +
                ", userAddressGeoLngDTO=' " + userAddressDTO.getGeoLocationDTO().getLng() + '\'' +
                ", userCompanyNameDTO=' " + userCompanyDTO.getCompanyName() + '\'' +
                ", userCompanyBSDTO=' " + userCompanyDTO.getBs() + '\'' +
                ", userCompanyCatchPhraseDTO=' " + userCompanyDTO.getCompanyName() + '\'' +
                '}';
    }
}
