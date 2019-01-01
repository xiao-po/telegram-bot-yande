package xyz.xiaopo.telegramBot.http;

import xyz.xiaopo.telegramBot.model.yande.YandeImage;

import java.util.List;

public interface YandeService {
    List<YandeImage> getImageByLimit(int limit);
}
