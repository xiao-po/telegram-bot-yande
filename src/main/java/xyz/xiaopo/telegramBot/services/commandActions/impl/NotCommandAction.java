package xyz.xiaopo.telegramBot.services.commandActions.impl;

import xyz.xiaopo.telegramBot.model.telegram.response.TelegramMessage;
import xyz.xiaopo.telegramBot.services.ReplyMessageService;
import xyz.xiaopo.telegramBot.services.commandActions.CommandAction;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramAction;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramCommand;
import org.springframework.beans.factory.annotation.Autowired;


@TelegramCommand
public class NotCommandAction implements CommandAction {
    @Autowired
    ReplyMessageService replyMessageService;

    @TelegramAction("/start")
    public void command(TelegramMessage message){
        this.replyMessageService.sendText(message.getChat().getId(), "成功测试");
    }
}
