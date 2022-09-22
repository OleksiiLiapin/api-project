package com.softserve.service;

import com.softserve.services.common.RestServices;
import com.softserve.settings.HTTPStatusList;
import com.softserve.util.ProvideServiceConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestUserApiConnection {
    @Test (description = "Verify that GET method returns 200 OK")
    void statusCodeIs200GetUser() {
        Logger log = Logger.getLogger(TestUserApiConnection.class.getName());
        given()
                .spec(RestServices.getReqSpec().baseUri(ProvideServiceConfig.getService("jsonPlaceholder")))
                .when()
                .get()
                .then()
                .statusCode(HTTPStatusList.OK)
                .log().headers();
        log.info("Initial response is done");
}
    }
