package com.example.springboot.http;

import com.example.springboot.model.yande.YandeImage;

import java.util.List;

public interface YandeService {
    List<YandeImage> getImageByLimit(int limit);
}
