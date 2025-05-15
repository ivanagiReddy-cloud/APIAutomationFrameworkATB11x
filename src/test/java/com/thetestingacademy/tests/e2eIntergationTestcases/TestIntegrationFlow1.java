package com.thetestingacademy.tests.e2eIntergationTestcases;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoint.APIConstants;
import com.thetestingacademy.pojos.request.Booking;
import com.thetestingacademy.pojos.response.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow1 extends BaseTest {
    //Test E2E Flow
    // 1. Create Booking , get Booking ID
    // 2. Create Token, get Token
    //3. Verify  Booking ID, with GET Request
    //4. Update the Booking, with PUT Request( need Token, Booking ID)
    // 5. Delete Booking ( Need Token, Booking ID)
    @Test(groups = "qa", priority = 1)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is created")
    public void testCreateBooking(ITestContext iTestContext) {
        requestSpecification.basePath(APIConstants.create_Update_Booking_URL);
        response = requestSpecification.when()
                .body(payLoadManager.createPayloadBookingasString())
                .log()
                .all()
                .post();
        System.out.println(response);
        BookingResponse bookingResponse = payLoadManager.bookingResponsejava(response.asString());

        assertActions.verifyStringkeyNotNull(bookingResponse.getBookingid());
        assertActions.verifySatusCode(response, 200);
        iTestContext.setAttribute("bookingID", bookingResponse.getBookingid());


    }

    @Test(groups = "qa", priority = 2)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is Verified")
    public void testVerifyBooking(ITestContext iTestContext) {
        // get the Booking ID
        Integer bookingID = (Integer) iTestContext.getAttribute("bookingID");
        // pass Booking ID in URL
        String basePathGET = APIConstants.create_Update_Booking_URL + "/" + bookingID;
        System.out.println(basePathGET);
        requestSpecification.basePath(basePathGET);
        response = requestSpecification.when()
                .log()
                .all()
                .get();
        System.out.println(response);
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payLoadManager.getResponseFromJSON(response.asString());

        assertActions.verifyStringKeyNotNull(booking.getFirstname());
        assertActions.verifyStringKeyNotNull(booking.getLastname());

    }

    @Test(groups = "qa", priority = 3)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is Updated")
    public void testUpdateBooking(ITestContext iTestContext) {
        Integer bookingID = (Integer) iTestContext.getAttribute("bookingID");

        String token = getToken();
        iTestContext.setAttribute("token", token);
        String basePath_PUT = APIConstants.create_Update_Booking_URL + "/" + bookingID;
        System.out.println(basePath_PUT);
        requestSpecification.basePath(basePath_PUT).cookie("token", token);
        response = requestSpecification.when().body(payLoadManager.updatePayloadBookingasString())
                .log()
                .all()
                .put();
        Booking booking = payLoadManager.getResponseFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(booking.getFirstname());
        assertActions.verifyStringKey(booking.getFirstname(), "Reddy");

    }

    @Test(groups = "qa", priority = 4)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is Deleted")
    public void testDeleteBooking(ITestContext iTestContext) {
        Integer bookingID = (Integer) iTestContext.getAttribute("bookingID");
        String token = (String) iTestContext.getAttribute("token");

        String basePath_DELETE = APIConstants.create_Update_Booking_URL + "/" + bookingID;
        System.out.println(basePath_DELETE);
        requestSpecification.basePath(basePath_DELETE).cookie("token", token);
        response = requestSpecification.when()
                .log()
                .all()
                .delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


    }

}
