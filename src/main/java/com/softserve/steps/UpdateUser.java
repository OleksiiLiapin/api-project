package com.softserve.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.user.Address;
import com.softserve.user.Company;
import com.softserve.user.GeoLocation;
import com.softserve.user.User;
import com.softserve.util.services.RestServices;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class UpdateUser {
    private static final Logger log = LogManager.getLogger(CreateUserList.class);

    public static User updateUser (User user, int ID) throws IOException {
        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put("https://jsonplaceholder.typicode.com/users/" + ID);

        if (ID > RestServices.getUsersCountByDefault()){
            log.error("Invalid User Id Provided: " + ID);
            assertThat(response.getStatusCode()).isEqualTo(404);
        }

        assertThat(response.getStatusCode()).isEqualTo(200);
        log.info("Put request to update user is done");
        String jsonString = response.asString();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString,User.class);
    }



}
