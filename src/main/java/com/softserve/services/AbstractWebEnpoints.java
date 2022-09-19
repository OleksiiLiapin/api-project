package com.softserve.services;

import com.softserve.model.user.UserDTO;
import com.softserve.settings.HTTPStatusList;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public abstract class AbstractWebEnpoints extends RestServices {
    private static final Logger LOG = LogManager.getLogger(AbstractWebEnpoints.class);

    public static ValidatableResponse getAllList(RequestSpecification reqSpecBuild, String path) { //get
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec.addRequestSpecification(reqSpecBuild);
        return given()
                .spec(spec.build())
                .when()
                .get(path)
                .then();
    }


    public static ValidatableResponse get(RequestSpecification requestSpecification, String path, String pathParam) {
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec.addRequestSpecification(requestSpecification).setBasePath(path);
        return given()
                .spec(spec.build())
                .when()
                .get(pathParam)
                .then();
    }


    public static ValidatableResponse post(RequestSpecification reqSpecBuild, String param, Object bodyPayload) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(reqSpecBuild);
        if (bodyPayload != null) {
            specBuilder.setBody(bodyPayload);
        }
        return given()
                .spec(specBuilder.build())
                .when()
                .post(param)
                .then();
    }


    public static ValidatableResponse put(RequestSpecification reqSpecBuild, String param, String pathParam, Object bodyPayload) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(reqSpecBuild).setBasePath(param);
        if (bodyPayload != null) {
            specBuilder.setBody(bodyPayload);
        }
        return given()
                .spec(specBuilder.build())
                .when()
                .put(pathParam)
                .then();
    }


//get() put() post() delete()

}
