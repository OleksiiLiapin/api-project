package com.softserve.services.clients;

import com.softserve.model.user.UserDTO;
import com.softserve.services.common.AbstractWebEnpoints;
import com.softserve.settings.HTTPStatusList;
import com.softserve.util.ProvideServiceConfig;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;


public class UserCRUD extends AbstractWebEnpoints {
    private static final Logger LOG = LogManager.getLogger(UserCRUD.class);
    private static final String BASE_URL = ProvideServiceConfig.getService("jsonPlaceholder");
    private static final String USERS_URL_ENDPOINT = "users";
    private static final RequestSpecification requestSpecification = getReqSpec().baseUri(BASE_URL);



    public static UserDTO getUserById(String id) {
        System.out.println("print response: " + getUserById("1", 200).toString());
        return getUserById(id, HTTPStatusList.OK)
                .extract().as(UserDTO.class);
    }

    protected static ValidatableResponse getUserById(String userId, Integer status) { //move to UserCRUD
        LOG.info("Get user by ID: " + userId);
        //RequestSpecification spec = requestSpecification;
        return get( //provide response
                requestSpecification, USERS_URL_ENDPOINT, userId)
                .statusCode(status);
    }

    public static ValidatableResponse createUser(UserDTO userDTO, Integer status) {
        LOG.info("Create new user with name: " + userDTO.getName());
        return post(requestSpecification,
                USERS_URL_ENDPOINT,
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
        return put(requestSpecification,
                USERS_URL_ENDPOINT,
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
        return getAllList(requestSpecification,
                USERS_URL_ENDPOINT)
                .assertThat()
                .statusCode(status);
    }

    public static List <UserDTO> getAll(){
        return Arrays.asList(getAll(requestSpecification, HTTPStatusList.OK)
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