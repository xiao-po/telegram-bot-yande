package com.example.springboot.http;

import com.example.springboot.model.telegram.reply.TelegramReplyMessage;

public interface TelegramSendService {
    void postText(TelegramReplyMessage message);
    void sendImage(TelegramReplyMessage message);
}
