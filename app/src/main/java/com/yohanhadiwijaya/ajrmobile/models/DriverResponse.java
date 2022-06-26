package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

public class DriverResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Driver driver;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setUser(Driver driver) {
        this.driver = driver;
    }
}
