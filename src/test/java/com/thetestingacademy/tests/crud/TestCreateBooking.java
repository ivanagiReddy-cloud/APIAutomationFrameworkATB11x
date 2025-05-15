package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoint.APIConstants;
import com.thetestingacademy.pojos.response.BookingResponse;
import com.thetestingacademy.pojos.response.TokenResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {


    @Owner("Siva")
    @Description("TC#1- Verify that Booking can be created ")
    @Test(groups = "reg", priority = 1)
    public void testCreateBooking_Positive() {

        //Setup and Making Request
        requestSpecification.basePath(APIConstants.create_Update_Booking_URL);
        response = requestSpecification.when().body(payLoadManager.createPayloadBookingasString())
                .log()
                .all()
                .post();
        System.out.println(response.asString());

        //Extraction
        BookingResponse bookingResponse = payLoadManager.bookingResponsejava(response.asString());

        //Verify
        assertActions.verifyStringkeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Siva");

    }

    @Owner("Siva")
    @Test
    @Description("TC#2- Verify Booking can't be created, since payload is empty")
    public void testCreateBookingNegetive() {
        requestSpecification.basePath(APIConstants.create_Update_Booking_URL);
        response = requestSpecification.when().body("{}")
                .log()
                .all()
                .post();
        validatableResponse = response.then()
                .statusCode(500)
                .log()
                .all();

    }

    @Owner("Siva")
    @Description("TC#3- Verify Booking can be Created with Random Payload")
    @Test
    public void testCreateBookingWithRandomValues() {

        requestSpecification.basePath(APIConstants.create_Update_Booking_URL);
        response = requestSpecification.when().body(payLoadManager.createPayloadBookingwithRandomValue())
                .log()
                .all()
                .post();

        //Extract
        BookingResponse bookingResponse = payLoadManager.bookingResponsejava(response.asString());

        //Verify
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());
        assertActions.verifyStringkeyNotNull(bookingResponse.getBookingid());
    }


}
