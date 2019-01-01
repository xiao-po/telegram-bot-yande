package xyz.xiaopo.telegramBot.services.impl;

import xyz.xiaopo.telegramBot.http.TelegramSendService;
import xyz.xiaopo.telegramBot.model.telegram.reply.TelegramReplyMessage;
import xyz.xiaopo.telegramBot.services.ReplyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyMessageServiceImpl implements ReplyMessageService {


    @Autowired
    TelegramSendService telegramSendService;

    @Override
    public void sendNoCommandMessage(Long chat_id) {
        TelegramReplyMessage message = new TelegramReplyMessage();
        message.setText("你输入的并不是命令");
        message.setChat_id(chat_id);
        this.telegramSendService.postText(message);
    }

    @Override
    public void sendText(Long chat_id, String text) {
        TelegramReplyMessage message = new TelegramReplyMessage();
        message.setText(text);
        message.setChat_id(chat_id);
        this.telegramSendService.postText(message);
    }
}

