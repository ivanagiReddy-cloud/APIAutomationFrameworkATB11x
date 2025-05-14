package com.thetestingacademy.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    //Common to All test case
    // Base URL, Headers, Content Type

    @BeforeTest
    public void setUp(){
        System.out.println("Starting of the Test!");

    }


    @AfterTest
    public void tearDown(){
        System.out.println("Finished the Test!");

    }
}
