package com.softserve.services.clients;

import com.softserve.model.user.UserDTO;
import com.softserve.services.AbstractWebEnpoints;
import com.softserve.services.RestServices;
import com.softserve.settings.HTTPStatusList;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserCRUD extends AbstractWebEnpoints {
    private static final Logger LOG = LogManager.getLogger(UserCRUD.class);



    public static UserDTO getUserById(String id) {
        System.out.println("print response: " + getUserById("1", 200).toString());
        return getUserById(id, HTTPStatusList.OK)
                .extract().as(UserDTO.class);
    }

    protected static ValidatableResponse getUserById(String userId, Integer status) { //move to UserCRUD
        LOG.info("Get user by ID: " + userId);
        RequestSpecification spec = getReqSpec();
        return get( //provide response
                spec, getUsersUrl(), userId)
                .statusCode(status);
    }

    public static ValidatableResponse createUser(UserDTO userDTO, Integer status) {
        LOG.info("Create new user with name: " + userDTO.getName());
        RequestSpecification spec = getReqSpec();
        return post(spec,
                getUsersUrl(),
                userDTO)
                .assertThat()
                .statusCode(status);
    }

    public static UserDTO createUser(UserDTO userDTO){
        return createUser(userDTO, HTTPStatusList.CREATE)
                .extract().as(UserDTO.class);
    }

    public static ValidatableResponse updateUser(UserDTO userDTO, String id, Integer status){
        LOG.info("Update user with id: " + id);
        RequestSpecification spec = getReqSpec();
        return put(spec,
                getUsersUrl(),
                id,
                userDTO)
                .assertThat()
                .statusCode(status)
                .log().all();
    }

    public static UserDTO updateUser(UserDTO userDTO, String id){
        return updateUser(userDTO,
                id,
                HTTPStatusList.OK)
                .extract().as(UserDTO.class);


    }

    public static ValidatableResponse getAll (RequestSpecification reqSpecBuild, Integer status){
        return getAllList(reqSpecBuild,
                getUsersUrl())
                .assertThat()
                .statusCode(status);
    }

    public static List <UserDTO> getAll(){
        RequestSpecification spec = getReqSpec();
        return Arrays.asList(getAll(spec, HTTPStatusList.OK)
                .extract().as(UserDTO[].class));

    }
//
//    public static List<UserDTO> getAllUserList(){
//        RequestSpecification spec = getReqSpec();
//        return Arrays.asList(getAllUserListResponse(spec, RestServices.getUsersUrl())
//                .extract()
//                .body()
//                .as(UserDTO[].class));
//    }

}