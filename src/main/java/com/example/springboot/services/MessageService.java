package com.example.springboot.services;

import com.example.springboot.model.telegram.response.TelegramResponse;
import com.example.springboot.model.telegram.response.TelegramResult;


public interface MessageService {

    void repeater(TelegramResult response);
}
