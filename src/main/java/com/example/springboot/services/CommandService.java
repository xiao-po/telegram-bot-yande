package com.example.springboot.services;

import com.example.springboot.model.command.CommandResponse;
import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import com.example.springboot.model.telegram.response.TelegramResult;

public interface CommandService {
    CommandResponse dispatch(TelegramResult result);
    TelegramReplyMessage replyNotCommand();
}
