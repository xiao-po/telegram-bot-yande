package xyz.xiaopo.telegramBot.services.commandActions.impl;

import xyz.xiaopo.telegramBot.http.TelegramSendService;
import xyz.xiaopo.telegramBot.http.YandeService;
import xyz.xiaopo.telegramBot.model.telegram.reply.TelegramReplyMessage;
import xyz.xiaopo.telegramBot.model.telegram.response.TelegramMessage;
import xyz.xiaopo.telegramBot.model.yande.YandeImage;
import xyz.xiaopo.telegramBot.services.commandActions.CommandAction;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramAction;
import xyz.xiaopo.telegramBot.services.commandActions.annotation.TelegramCommand;
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
        List<YandeImage> imageList = this.yandeService.getImageByLimit(20);
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
