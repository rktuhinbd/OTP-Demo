package com.rktuhinbd.myapplication.Model;

public class OtpModel {
    private String apiKey, messageType, contact, senderId, message;

    public OtpModel(String apiKey, String messageType, String contact, String senderId, String message) {
        this.apiKey = apiKey;
        this.messageType = messageType;
        this.contact = contact;
        this.senderId = senderId;
        this.message = message;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getContact() {
        return contact;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }
}
