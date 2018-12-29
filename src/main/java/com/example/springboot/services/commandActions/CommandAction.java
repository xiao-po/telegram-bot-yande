package com.example.springboot.services.commandActions;


import com.example.springboot.model.telegram.response.TelegramMessage;

public interface CommandAction {
    void command(TelegramMessage message);
}
