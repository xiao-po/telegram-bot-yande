package com.example.springboot.model.telegram.response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelegramResult {
    TelegramMessage message;
    int update_id;

    public TelegramResult() {
    }

    public TelegramMessage getMessage() {
        return message;
    }

    public void setMessage(TelegramMessage message) {
        this.message = message;
    }

    public boolean isCommand(){
        Matcher matcher = this.getCommandRegexp().matcher(this.getMessage().text);
        return matcher.matches();
    }

    private Pattern getCommandRegexp(){
        String commandRegexpText = "^/.*";
        return Pattern.compile(commandRegexpText);
    }
}