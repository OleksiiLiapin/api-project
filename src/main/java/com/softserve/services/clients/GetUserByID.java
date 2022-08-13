package com.softserve.services.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.model.user.UserDTO;
import com.softserve.services.RestServices;
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

    public static UserDTO getUSerByID (int ID) throws IOException {
        List <UserDTO> userDTOList = CreateUserList.createUserList();
        if (ID>RestServices.getUsersCountByDefault()){
            log.error("ID " + ID + " is invalid");
        }
        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(userDTOList.get(ID-1)) //ID-1 means the user position in ArrayList
                .get(RestServices.getBase_URL() + RestServices.getUsersUrl() + ID);
        assertThat(response.getStatusCode()).isEqualTo(200);
        log.info("User with ID: " + ID + " is retrieved");
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = response.asString();
        return mapper.readValue(jsonResponse, UserDTO.class);
    }

}
