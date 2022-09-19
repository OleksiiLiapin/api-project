package com.softserve.service;

import com.softserve.services.RestServices;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserApiConnection {
    @Test (description = "Verify that GET method returns 200 OK")
    void statusCodeIs200GetUser() {
        Logger log = Logger.getLogger(TestUserApiConnection.class.getName());
        try  {
            Response response = RestAssured.get(RestServices.getBase_URL()+RestServices.getUsersUrl());
            Assert.assertEquals(200, response.getStatusCode());
            log.info("Initial code responce for "
                    + RestServices.getBase_URL() + RestServices.getUsersUrl() + " is 200");
        }
        catch (Exception e){
            log.error("Connection failed or responce is not 200");
        }
    }


}
