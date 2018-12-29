package com.example.springboot.model.command;

import com.example.springboot.value.CommandMessage;

public class CommandResponse {
    boolean isCorrect;
    String message;

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommandResponse() {
    }

    public CommandResponse(boolean isCorrect, String message) {
        this.isCorrect = isCorrect;
        this.message = message;
    }

    public static CommandResponse NotCommand() {
        return new CommandResponse(false, CommandMessage.NOT_COMMAND);
    }
}