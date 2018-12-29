package com.example.springboot.services.commandActions.impl;

import com.example.springboot.model.telegram.response.TelegramMessage;
import com.example.springboot.services.commandActions.CommandAction;
import com.example.springboot.services.commandActions.annotation.TelegramCommand;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;


@TelegramCommand("/start")
public class NotCommandAction implements CommandAction {
    public void command(TelegramMessage message){
        System.out.println(
                "message is coming"
        );
    }
}
