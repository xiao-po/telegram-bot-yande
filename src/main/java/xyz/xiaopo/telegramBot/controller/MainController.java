package xyz.xiaopo.telegramBot.controller;

import xyz.xiaopo.telegramBot.model.telegram.response.TelegramResult;
import xyz.xiaopo.telegramBot.services.CommandService;
import xyz.xiaopo.telegramBot.services.ReplyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    CommandService commandService;
    @Autowired
    ReplyMessageService replyMessageService;


    @GetMapping("/")
    String index(){
        return "hello,world!";
    }


    @PostMapping("/getMessages")
    String getMessages(@RequestBody TelegramResult telegramResult){
        // 判断是否是command
        if (!telegramResult.isCommand()) {
            this.replyMessageService.sendNoCommandMessage(telegramResult.getMessage().getChat().getId());
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
