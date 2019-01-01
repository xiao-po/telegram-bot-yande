package com.example.springboot.services.commandActions;


import com.example.springboot.model.telegram.response.TelegramMessage;
import com.example.springboot.services.commandActions.annotation.TelegramAction;
import com.example.springboot.services.commandActions.annotation.TelegramCommand;

@TelegramCommand
public interface CommandAction {
    @TelegramAction
    void command(TelegramMessage message);
}
