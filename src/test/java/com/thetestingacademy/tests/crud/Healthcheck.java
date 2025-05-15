package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class Healthcheck extends BaseTest {

    @Description("TC#1- Verify Healthcheck ")
    @Owner("Siva")
    @Test(groups = "Reg", priority = 1)
public void testGETHealthCheck(){
    requestSpecification.basePath(APIConstants.ping_URL);
    response = requestSpecification.when().log().all().get();
    validatableResponse =response.then().log().all().statusCode(201);
}
}
