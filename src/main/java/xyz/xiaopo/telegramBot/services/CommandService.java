package xyz.xiaopo.telegramBot.services;

import xyz.xiaopo.telegramBot.model.telegram.reply.TelegramReplyMessage;
import xyz.xiaopo.telegramBot.model.telegram.response.TelegramResult;

public interface CommandService {
    void dispatch(TelegramResult result);
    TelegramReplyMessage replyNotCommand();
}
