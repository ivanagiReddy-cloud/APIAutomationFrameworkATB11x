package com.thetestingacademy.base;

import com.thetestingacademy.assertions.AssertActions;
import com.thetestingacademy.endpoint.APIConstants;
import com.thetestingacademy.modules.PayLoadManager;
import com.thetestingacademy.pojos.response.TokenResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    //Common to All test case
    // Base URL, Headers, Content Type

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public JsonPath jsonPath;
    public PayLoadManager payLoadManager;
    public AssertActions assertActions;


    @BeforeTest
    public void setUp() {
        System.out.println("Starting of the Test!");
        payLoadManager = new PayLoadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.baseURL);
        requestSpecification.contentType(ContentType.JSON)
                .log()
                .all();
//        //Another Way
//        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri(APIConstants.baseURL)
//                .addHeader("Content-Type", "Application/json")
//                .build().log().all();


    }

    public String getToken() {

        requestSpecification.basePath(APIConstants.auth_URL);
        String payLoad = payLoadManager.setAuthenticationPayload();
        response = requestSpecification.body(payLoad).when().post();
        String token = payLoadManager.gettokenResponse(response.asString());
        return token;

    }

    @AfterTest
    public void tearDown() {
        System.out.println("Finished the Test!");

    }
}
