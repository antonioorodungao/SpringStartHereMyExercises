package com.example.ch10_restwebservices.models;



public class ErrorDetails {
    private String message;

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message){
        this.message=message;
    }
}
