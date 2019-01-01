package com.example.springboot.services.commandActions.impl;

import com.example.springboot.model.telegram.response.TelegramMessage;
import com.example.springboot.services.ReplyMessageService;
import com.example.springboot.services.commandActions.CommandAction;
import com.example.springboot.services.commandActions.annotation.TelegramAction;
import com.example.springboot.services.commandActions.annotation.TelegramCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;


@TelegramCommand
public class NotCommandAction implements CommandAction {
    @Autowired
    ReplyMessageService replyMessageService;

    @TelegramAction("/start")
    public void command(TelegramMessage message){
        this.replyMessageService.sendText(message.getChat().getId(), "成功测试");
    }
}
