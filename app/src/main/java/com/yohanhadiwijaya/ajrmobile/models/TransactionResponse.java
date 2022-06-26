package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Transaction> transactionList;

    public String getMessage(){
        return message;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
