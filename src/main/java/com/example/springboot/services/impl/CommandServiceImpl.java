package com.example.springboot.services.impl;

import com.example.springboot.model.command.CommandResponse;
import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import com.example.springboot.model.telegram.response.TelegramResult;
import com.example.springboot.services.CommandService;
import com.example.springboot.services.commandActions.annotation.TelegramCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    ApplicationContext applicationContext;


    @Override
    public CommandResponse dispatch(TelegramResult result) {
        Map<String, Object> telegramCommand = this.applicationContext.getBeansWithAnnotation(TelegramCommand.class);
        for (Map.Entry<String, Object> action : telegramCommand.entrySet()) {
            if (action.getKey().equals(result.getMessage().getText())) {
                try {
                    final Method method = (Method) action.getValue();
                    method.invoke(null, result.getMessage());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public TelegramReplyMessage replyNotCommand() {
        return null;
    }
}

