package com.softserve.services;

import com.softserve.util.ProvideServiceConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestServices {
    private static final String BASE_URL = ProvideServiceConfig.getService("jsonPlaceholder");
    private static final String USERS_URL_ENDPOINT = "users";

    public RestServices() {
    }

    public static String getBase_URL(){
        return BASE_URL;
    }
    public static String getUsersUrl(){
        return USERS_URL_ENDPOINT;
    }


//Specification
    public static RequestSpecification getReqSpec (){
       RequestSpecBuilder REQ_SPEC =
                new RequestSpecBuilder()
                        .setBaseUri(getBase_URL())
                        .setContentType(ContentType.JSON);
       return REQ_SPEC.build();
    }

}
