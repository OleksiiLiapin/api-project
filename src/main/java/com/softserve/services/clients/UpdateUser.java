package com.softserve.services.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.model.user.UserDTO;
import com.softserve.services.RestServices;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class UpdateUser {
    private static final Logger log = LogManager.getLogger(CreateUserList.class);

    public static UserDTO updateUser (UserDTO userDTO, int ID) throws IOException {
        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(userDTO)
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
        return mapper.readValue(jsonString, UserDTO.class);
    }



}
