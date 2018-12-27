package com.example.springboot.model.telegram.response;

import java.util.List;

public class TelegramMessage {
    TelegramUser chat;
    TelegramUser from;
    List<TelegramEntity> entities;
    String text;

    public TelegramUser getChat() {
        return chat;
    }

    public void setChat(TelegramUser chat) {
        this.chat = chat;
    }

    public TelegramUser getFrom() {
        return from;
    }

    public void setFrom(TelegramUser from) {
        this.from = from;
    }

    public List<TelegramEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<TelegramEntity> entities) {
        this.entities = entities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TelegramMessage() {
    }
}
