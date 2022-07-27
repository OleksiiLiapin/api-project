package com.softserve;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.steps.CreateNewUser;
import com.softserve.steps.CreateUserList;
import com.softserve.steps.UpdateUser;
import com.softserve.user.*;
import com.softserve.util.services.RestServices;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;


import static io.restassured.RestAssured.request;
import static io.restassured.RestAssured.given;



public class Main {

    static Logger log = Logger.getLogger(CreateUserList.class.getName());
    public static void main(String[] args) throws IOException {


        //System.out.println(list.get(0).getName());

        User user = new User(
                1,
                "Alex", "Cherry",
                "Alexcherry@mail.com",
                "3928-28-11-1",
                "cherry.net",
                new Address("London", "St. Green", "3782", "392",
                        new GeoLocation("-1.2334", "2.283")),
                new Company("Bull Co", "Be brave", "JP")
        );

        ArrayList<User> userList = CreateUserList.createUserList();
        int a = 0;
            Response response = given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .when()
                    .body(userList.get(0))
                    .get(RestServices.getBase_URL() + RestServices.getUsersUrl() + 1);

        String jsonResponce = response.asString();
        ObjectMapper mapper = new ObjectMapper();
        User user1 = mapper.readValue(jsonResponce, User.class);
        System.out.println(user1.getName());
        System.out.println(user1.getId());







        }
    }





