package xyz.xiaopo.telegramBot.services.commandActions;


import xyz.xiaopo.telegramBot.model.telegram.response.TelegramMessage;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramAction;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramCommand;

@TelegramCommand
public interface CommandAction {
    @TelegramAction
    void command(TelegramMessage message);
}
