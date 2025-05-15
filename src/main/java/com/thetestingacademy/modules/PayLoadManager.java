package com.thetestingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.pojos.request.Authentication;
import com.thetestingacademy.pojos.request.Booking;
import com.thetestingacademy.pojos.request.BookingDates;
import com.thetestingacademy.pojos.response.BookingResponse;
import com.thetestingacademy.pojos.response.TokenResponse;

public class PayLoadManager {

    Gson gson;
    Faker faker;

    //Convert Java Object into Json String to use as Payload
    //Serialization
    public String createPayloadBookingasString() {
        Booking booking = new Booking();
        booking.setFirstname("Siva");
        booking.setLastname("Muli");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // This is reference of java Object, we need to convert to JSON
        // this is called Serialization
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;
    }

    public String createPayloadBookingwithRandomValue() {
        faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1, 1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds(faker.food().dish());

        System.out.println(booking);

        // This is reference of java Object, we need to convert to JSON
        // this is called Serialization
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;
    }

    public String updatePayloadBookingasString() {
        Booking booking = new Booking();
        booking.setFirstname("Reddy");
        booking.setLastname("Nagi");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // This is reference of java Object, we need to convert to JSON
        // this is called Serialization
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;
    }

    //Convert Json String into java Object, so that we can verify
    // Deserialization
    public BookingResponse bookingResponsejava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    //Converting Java object to JSON
    public String setAuthenticationPayload() {
        Authentication authentication = new Authentication();
        authentication.setUsername("admin");
        authentication.setPassword("password123");
        Gson gson = new Gson();
        String jsonPayloadString = gson.toJson(authentication);
        return jsonPayloadString;
    }

    //Deserialization JSON->java Object
    public String gettokenResponse(String tokenString) {
        gson = new Gson();
        TokenResponse tokenResponse = gson.fromJson(tokenString, TokenResponse.class);
        return tokenResponse.getToken();
    }

    public Booking getResponseFromJSON(String getResponse) {
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }

}
