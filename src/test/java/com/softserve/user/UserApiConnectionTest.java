package com.softserve.user;

import com.softserve.steps.CreateUserList;
import com.softserve.util.services.RestServices;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class UserApiConnectionTest {
    @Test
    void statusCodeIs200GetUser() {
        Logger log = Logger.getLogger(UserApiConnectionTest.class.getName());
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
