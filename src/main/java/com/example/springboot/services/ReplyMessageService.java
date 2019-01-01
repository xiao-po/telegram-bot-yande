package com.example.springboot.services;

import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import org.springframework.stereotype.Service;

@Service
public interface ReplyMessageService {
    void sendNoCommandMessage(int chat_id);
    void sendText(int chat_id, String text);
}
