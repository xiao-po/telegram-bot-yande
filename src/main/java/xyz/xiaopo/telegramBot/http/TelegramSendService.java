package xyz.xiaopo.telegramBot.http;

import xyz.xiaopo.telegramBot.model.telegram.reply.TelegramReplyMessage;

public interface TelegramSendService {
    void postText(TelegramReplyMessage message);
    void sendImage(TelegramReplyMessage message);
}
