package xyz.xiaopo.telegramBot.model.telegram.response;

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
        try {
            Matcher matcher = this.getCommandRegexp().matcher(this.getMessage().text);
            return matcher.matches();
        } catch (Exception e) {
            return false;
        }
    }

    private Pattern getCommandRegexp(){
        String commandRegexpText = "^/.*";
        return Pattern.compile(commandRegexpText);
    }
}