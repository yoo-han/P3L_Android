package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

public class CustomerResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Customer customer;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }
}
