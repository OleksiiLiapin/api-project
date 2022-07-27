package com.softserve.steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.softserve.user.Address;
import com.softserve.user.Company;
import com.softserve.user.GeoLocation;
import com.softserve.user.User;
import com.softserve.util.services.RestServices;
import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;

public class CreateNewUser {
    private static final Logger log = LogManager.getLogger(GetUserByID.class);

    public static User createNewUser(User rootUser) throws JsonProcessingException {

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(rootUser)
                .post(RestServices.getBase_URL() + RestServices.getUsersUrl());

        Assert.assertEquals(201, response.getStatusCode());

            String jsonString = response.asString();
            ObjectMapper mapper = new ObjectMapper();
            log.info("User created");
            return mapper.readValue(jsonString, User.class);

    }


}
