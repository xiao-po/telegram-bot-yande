package com.example.springboot.controller;

import com.example.springboot.model.telegram.response.TelegramResult;
import com.example.springboot.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    MessageService messageService;


    @GetMapping("/")
    String index(){
        return "hello,world!";
    }


    @PostMapping("/getMessages")
    String getMessages(@RequestBody TelegramResult telegramResult){
        messageService.repeater(telegramResult);
        return "ok";
    }
    @GetMapping("/getMessages")
    String noAction(){
        return "sorry, it's no actions.";
    }
}
