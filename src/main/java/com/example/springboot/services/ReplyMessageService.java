package com.example.springboot.services;

import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import org.springframework.stereotype.Service;

@Service
public interface ReplyMessageService {
    void sendText(TelegramReplyMessage message);
    void sendImage(TelegramReplyMessage message);
}
