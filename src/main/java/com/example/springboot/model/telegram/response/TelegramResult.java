package com.example.springboot.model.telegram.response;

public class TelegramResult {
    TelegramMessage message;
    int update_id;

    public TelegramResult() {
    }

    public TelegramMessage getMessage() {
        return message;
    }

    public void setMessage(TelegramMessage message) {
        this.message = message;
    }
}