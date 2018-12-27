package com.example.springboot.model.telegram.response;

public class TelegramResponse {
    Boolean ok;
    TelegramResult result;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public TelegramResult getResult() {
        return result;
    }

    public void setResult(TelegramResult result) {
        this.result = result;
    }

    public TelegramResponse() {
    }

}
