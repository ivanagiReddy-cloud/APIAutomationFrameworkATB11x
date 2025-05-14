package com.thetestingacademy.assertions;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.assertEquals;

public class AssertActions {

    //String verification
    public void verifResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }

    //Integer verification
    public void verifResponseBody(int actual, int expected, int description) {
        assertEquals(actual, expected, description);

    }

    //Status code verification
    public void verifySatusCode(Response response, Integer expected) {
        assertEquals(response.statusCode(), expected);

    }

    //Assert J
    public void verifyStringKey(String keyExpect, String keyActual) {

        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotEmpty();
        assertThat(keyExpect).isEqualTo(keyActual);
    }

    public void verifyStringkeyNotNull(Integer keyExpect) {
        assertThat(keyExpect).isNotNull();
    }

    public void verifyStringKeyNotNull(String keyExpect) {
        assertThat(keyExpect).isNotNull();
    }
}
