package com.softserve.services.clients;

import com.softserve.model.user.UserDTO;
import com.softserve.services.RestServices;
import com.softserve.settings.HTTPStatusList;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.AssertionErrorCollector;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import io.restassured.internal.http.Status;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import static io.restassured.RestAssured.given;

public abstract class AbstractWebEnpoints extends RestServices {
    private static final Logger LOG = LogManager.getLogger(AbstractWebEnpoints.class);

    public static ValidatableResponse getAllUserListResponse(RequestSpecification reqSpecBuild, String userParam){
        reqSpecBuild = getReqSpec();
        reqSpecBuild.basePath(userParam);
        return given()
                .spec(reqSpecBuild)
                .when()
                .get()
                .then()
                .assertThat().statusCode(HTTPStatusList.OK);
    }

    public static List<UserDTO> getAllUserList(){
        RequestSpecification spec = getReqSpec();
       return Arrays.asList(getAllUserListResponse(spec, RestServices.getUsersUrl())
               .extract()
               .body()
               .as(UserDTO[].class));
    }


    public static ValidatableResponse getUserByIdResponse(RequestSpecification reqSpecBuild, String userParam, String userID){
       reqSpecBuild = getReqSpec(); //get spec with base URL - placeholder.com
       reqSpecBuild.basePath(userParam); //provide basePath 'baseURI/basePath' - {users}
        return given()
                .spec(reqSpecBuild)
                .when()
                .get(userID)  //provide ID to URL 'baseURI/users/ID' - 1-10
                .then();
    }

    public static UserDTO getUserById(String userId){
        RequestSpecification spec = getReqSpec();
        return getUserByIdResponse( //provide response
            spec, RestServices.getUsersUrl(), userId)
                .assertThat().statusCode(HTTPStatusList.OK)
                .extract().as(UserDTO.class); //extract UserDTO and check the statusCode
    }


    public static ValidatableResponse createUserResponse(RequestSpecification reqSpecBuild, String userParam, String userID){
        reqSpecBuild = getReqSpec();
        reqSpecBuild.basePath(userParam);
        return given()
                .spec(reqSpecBuild)
                .body(UserDTO.createRootUser().setId(userID))
                .when()
                .post()
                .then()
                .log().body();
    }

    public static UserDTO createUser(String userID){
        RequestSpecification spec = getReqSpec();
        return createUserResponse(spec, getUsersUrl(), userID)
                .assertThat().statusCode(HTTPStatusList.CREATE)
                .extract()
                .as(UserDTO.class);
    }

    public static ValidatableResponse updateUserResponse(RequestSpecification reqSpecBuild, String userParam, String userID, UserDTO userDTO){
        reqSpecBuild = getReqSpec().basePath(userParam);
        return given()
                .spec(reqSpecBuild)
                .body(userDTO.setId(userID))
                .when()
                .put(userID)
                .then().log().all();
    }

    public static UserDTO updateUserById(String userID, UserDTO userDTO){
        RequestSpecification spec = getReqSpec();
        if (Integer.parseInt(userID) <= 10) {
            return updateUserResponse(spec, getUsersUrl(), userID, userDTO)
                    .assertThat().statusCode(HTTPStatusList.OK)
                    .extract()
                    .as(UserDTO.class);
        }
        else {
            return updateUserResponse(spec, getUsersUrl(), userID, userDTO)
                    .assertThat().statusCode(HTTPStatusList.INTERNAL_SERVER_ERROR)
                    .extract()
                    .as(UserDTO.class);
        }


    }



//get() put() post() delete()



}
