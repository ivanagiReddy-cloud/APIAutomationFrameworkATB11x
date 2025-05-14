package com.thetestingacademy.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {
    //create Booking
    // Verify
    //Update
    //delete
    // Sample test case-> Dry Run


    @Test(groups = "qa", priority = 1)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is created")
    public void testCreateBooking(){
        Assert.assertTrue(true);

    }

    @Test(groups = "qa", priority = 2)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is Verified")
    public void testVerifyBooking(){
        Assert.assertTrue(true);

    }

    @Test(groups = "qa", priority = 3)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is Updated")
    public void testUpdateBooking(){
        Assert.assertTrue(true);

    }

    @Test(groups = "qa", priority = 4)
    @Owner("Siva")
    @Description("TC#1 Step-1, Verify that booking is Deleted")
    public void testDeleteBooking(){
        Assert.assertTrue(true);

    }



}
