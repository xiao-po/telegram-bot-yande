package xyz.xiaopo.telegramBot.services;

import org.springframework.stereotype.Service;

@Service
public interface ReplyMessageService {
    void sendNoCommandMessage(Long chat_id);
    void sendText(Long chat_id, String text);
}
