package com.example.springboot.services.impl;

import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import com.example.springboot.model.telegram.response.TelegramMessage;
import com.example.springboot.model.telegram.response.TelegramResponse;
import com.example.springboot.model.telegram.response.TelegramResult;
import com.example.springboot.services.MessageService;
import com.example.springboot.services.ReplyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    ReplyMessageService replyMessageService;

    @Override
    public void repeater(TelegramResult response) {
        TelegramReplyMessage message = new TelegramReplyMessage();
        TelegramMessage responseMessage = response.getMessage();
        message.setChat_id(responseMessage.getChat().getId());
        message.setText(responseMessage.getText());

        replyMessageService.sendImage(message);
    }
}
