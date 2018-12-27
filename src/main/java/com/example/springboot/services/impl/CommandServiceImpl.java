package com.example.springboot.services.impl;

import com.example.springboot.model.command.CommandResponse;
import com.example.springboot.services.CommandService;
import com.example.springboot.value.CommandMessage;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CommandServiceImpl implements CommandService {
    @Override
    public CommandResponse dispatch(String commandText) {
        if (!this.isCommand(commandText)) return new CommandResponse(false, CommandMessage.NOT_COMMAND);

    }

    @Override
    public void uploadImage() {

    }

    @Override
    public void banTag() {

    }




    Pattern getCommandRegexp(){
        String commandRegexpText = "^/.*";
        return Pattern.compile(commandRegexpText);
    }

    boolean isCommand(String command){
        Matcher matcher = this.getCommandRegexp().matcher(command);
        return matcher.matches();
    }
}

