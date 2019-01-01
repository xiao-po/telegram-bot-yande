package com.example.springboot.http.service;

import com.example.springboot.http.YandeService;
import com.example.springboot.model.yande.YandeImage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class YandeServiceImpl implements YandeService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${yande.postApi}")
    private String url;

    @Override
    public List<YandeImage> getImageByLimit(int limit) {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = restTemplate.getForObject(
                url + "?limit=" + limit ,
                String.class);
        List<YandeImage> images = new ArrayList<>();
        try {
            images = objectMapper.readValue(result, new TypeReference<List<YandeImage>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}
