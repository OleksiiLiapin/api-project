package com.softserve.services.common;

import com.softserve.util.ProvideServiceConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestServices {

    public static RequestSpecification getReqSpec (){
       RequestSpecBuilder REQ_SPEC =
                new RequestSpecBuilder()
                        .setContentType(ContentType.JSON);
       return REQ_SPEC.build();
    }

}
