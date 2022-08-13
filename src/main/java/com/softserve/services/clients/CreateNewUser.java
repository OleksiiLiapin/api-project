package com.softserve.services.clients;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.softserve.model.user.UserDTO;
import com.softserve.services.RestServices;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;

public class CreateNewUser {
    private static final Logger log = LogManager.getLogger(GetUserByID.class);

    public static UserDTO createNewUser(UserDTO rootUserDTO) throws JsonProcessingException {
        ValidatableResponse response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(rootUserDTO)
                .post(RestServices.getBase_URL() + RestServices.getUsersUrl())
                        .then().statusCode(201);



            String jsonString = response.extract().asString();
            ObjectMapper mapper = new ObjectMapper();
            log.info("User created");
            return mapper.readValue(jsonString, UserDTO.class);

    }


}
