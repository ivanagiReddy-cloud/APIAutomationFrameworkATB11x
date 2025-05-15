package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoint.APIConstants;
import com.thetestingacademy.pojos.response.TokenResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class CreateToken extends BaseTest {
    @Owner("Siva")
    @Description("TC#1- Verify that Token Can be created")
    @Test(groups = "reg", priority = 2)
    public void testCreateTokenPOST() {

        //Make Request
        requestSpecification.basePath(APIConstants.auth_URL);
        response = requestSpecification.when()
                .body(payLoadManager.setAuthenticationPayload())
                .log()
                .all()
                .post();
        System.out.println(response.asString());

        //Extract
        TokenResponse tokenResponse = payLoadManager.
                gettokenResponse(response.asString());
        //Verify
        assertActions.verifyStringKeyNotNull(tokenResponse.getToken());

    }
}
