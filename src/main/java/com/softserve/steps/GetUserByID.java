package com.softserve.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.user.User;
import com.softserve.util.services.RestServices;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetUserByID {
    private static final Logger log = LogManager.getLogger(GetUserByID.class);

    public static User getUSerByID (ArrayList<User> userList, int ID) throws IOException {
        if (ID>RestServices.getUsersCountByDefault()){
            log.error("ID " + ID + " is invalid");
        }
        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(userList.get(ID-1)) //ID-1 means the user position in ArrayList
                .get(RestServices.getBase_URL() + RestServices.getUsersUrl() + ID);
        assertThat(response.getStatusCode()).isEqualTo(200);
        log.info("User with ID: " + ID + " is retrieved");
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = response.asString();
        return mapper.readValue(jsonResponse, User.class);
    }

}
