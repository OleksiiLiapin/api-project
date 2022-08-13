package com.softserve;

import com.softserve.model.user.UserDTO;
import com.softserve.services.clients.CreateUserList;
import org.apache.log4j.Logger;

import java.io.IOException;


import static io.restassured.RestAssured.request;
import static io.restassured.RestAssured.given;



public class Main {

    static Logger log = Logger.getLogger(CreateUserList.class.getName());

    public static void main(String[] args) throws IOException {


        UserDTO dto = UserDTO.createBasicUser();

        System.out.println(
                dto.getName() + " " +
                        dto.getUsername()
        );

        System.out.println(dto.getUserAddress().getCity());
        System.out.println(dto.getUserCompany().getCompanyName());
        System.out.println(dto.getUserAddress().getGeoLocationDTO().getLat());
        System.out.println(dto.getUserAddress().getGeoLocationDTO().getLng());

        System.out.println(dto.toString());

//        List<UserDTO> dtoList = CreateUserList.createUserList();
//        dtoList.stream().forEach(userDTO -> {
//            System.out.println("id:" + userDTO.getId() + " name: " +userDTO.getName());
//        });

    }
}





