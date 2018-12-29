package com.example.springboot.controller;

import com.example.springboot.model.command.CommandResponse;
import com.example.springboot.model.telegram.response.TelegramResult;
import com.example.springboot.services.CommandService;
import com.example.springboot.services.MessageService;
import com.example.springboot.value.CommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    CommandService commandService;


    @GetMapping("/")
    String index(){
        return "hello,world!";
    }


    @PostMapping("/getMessages")
    String getMessages(@RequestBody TelegramResult telegramResult){
        // 判断是否是command
        if (!telegramResult.isCommand()) {
            this.commandService.replyNotCommand();
        } else {
            this.commandService.dispatch(telegramResult);
        }

        return "ok";
    }
    @GetMapping("/getMessages")
    String noAction(){
        return "sorry, it's no actions.";
    }
}
