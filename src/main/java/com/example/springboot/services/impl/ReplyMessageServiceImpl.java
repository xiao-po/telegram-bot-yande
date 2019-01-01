package com.example.springboot.services.impl;

import com.example.springboot.http.TelegramSendService;
import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import com.example.springboot.services.ReplyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyMessageServiceImpl implements ReplyMessageService {


    @Autowired
    TelegramSendService telegramSendService;

    @Override
    public void sendNoCommandMessage(int chat_id) {
        TelegramReplyMessage message = new TelegramReplyMessage();
        message.setText("你输入的并不是命令");
        message.setChat_id(chat_id);
        this.telegramSendService.postText(message);
    }

    @Override
    public void sendText(int chat_id, String text) {
        TelegramReplyMessage message = new TelegramReplyMessage();
        message.setText(text);
        message.setChat_id(chat_id);
        this.telegramSendService.postText(message);
    }
}

