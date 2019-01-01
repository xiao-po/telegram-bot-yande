package com.example.springboot.services.commandActions.impl;

import com.example.springboot.http.TelegramSendService;
import com.example.springboot.http.YandeService;
import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import com.example.springboot.model.telegram.response.TelegramMessage;
import com.example.springboot.model.yande.YandeImage;
import com.example.springboot.services.ReplyMessageService;
import com.example.springboot.services.commandActions.CommandAction;
import com.example.springboot.services.commandActions.annotation.TelegramAction;
import com.example.springboot.services.commandActions.annotation.TelegramCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@TelegramCommand
public class GetImageAction implements CommandAction {
    static int lastImageId = 0;

    @Autowired
    YandeService yandeService;
    @Autowired
    TelegramSendService telegramSendService;

    @Override
    @TelegramAction("/image")
    public void command(TelegramMessage message) {
        List<YandeImage> imageList = this.yandeService.getImageByLimit(10);
        for (YandeImage image : imageList) {
            if (image.getId() == GetImageAction.lastImageId) {
                break;
            }
            TelegramReplyMessage replyMessage = new TelegramReplyMessage();
            replyMessage.setChat_id(message.getChat().getId());
            replyMessage.setText(image.getSample_url());
            this.telegramSendService.sendImage(replyMessage);
        }
        GetImageAction.lastImageId = imageList.get(0).getId();
    }
}
