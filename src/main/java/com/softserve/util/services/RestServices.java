package com.softserve.util.services;

import com.softserve.steps.CreateUserList;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public abstract class RestServices {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String USERS_URL = "users/";


    private static final Integer usersCountByDefault = 0;

    public static String getBase_URL(){
        return BASE_URL;
    }
    public static String getUsersUrl(){
        return USERS_URL;
    }
//    public static String getUSER_UPDATE_id(){
//        return USER_UPDATE_id;
//    }
    public static Integer getUsersCountByDefault() throws IOException {
        return CreateUserList.createUserList().size();
    }



    public static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(getBase_URL())
                    .setBasePath(getUsersUrl())
                    .setContentType(ContentType.JSON)
                    .build();
}
