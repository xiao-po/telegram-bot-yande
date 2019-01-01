package xyz.xiaopo.telegramBot.services.impl;

import xyz.xiaopo.telegramBot.model.telegram.reply.TelegramReplyMessage;
import xyz.xiaopo.telegramBot.model.telegram.response.TelegramResult;
import xyz.xiaopo.telegramBot.services.CommandService;
import xyz.xiaopo.telegramBot.services.ReplyMessageService;
import xyz.xiaopo.telegramBot.services.commandActions.CommandAction;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramAction;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    ReplyMessageService replyMessageService;


    @Override
    public void dispatch(TelegramResult result) {
        Map<String, Object> telegramCommand = this.applicationContext.getBeansWithAnnotation(TelegramCommand.class);
        boolean isCommand = false;
        for (final Object action : telegramCommand.values()) {
            final Class<CommandAction> commandObject = (Class<CommandAction>) action.getClass();
            for (Method method : commandObject.getDeclaredMethods()) {
                TelegramAction command = method.getAnnotation(TelegramAction.class);
                if (command != null && command.value().equals(result.getMessage().getText())) {
                    isCommand = true;
                    try {
                        method.invoke(
                                action,
                                result.getMessage()
                        );
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!isCommand) {
            this.replyMessageService.sendNoCommandMessage(result.getMessage().getChat().getId());
        }
    }

    @Override
    public TelegramReplyMessage replyNotCommand() {
        return null;
    }
}

