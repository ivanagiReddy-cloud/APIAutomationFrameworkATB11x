package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {


    @Owner("Siva")
    @Description("TC#1- Verify that Booking can be created ")
    @Test(groups = "reg", priority = 1)
    public void testCreateBooking_Positive(){
        System.out.println(" I am Positive Test case");
    }

    @Owner("Siva")
    @Description("TC#1- Verify that Booking can not be created,(when payload is wrong) ")
    @Test(groups = "reg", priority = 2)
    public void testCreateBooking_Negetive(){
        System.out.println(" I am Negetive Test case");
    }
}
