package com.example.springboot.services.impl;

import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import com.example.springboot.services.ReplyMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReplyMessageServiceImpl implements ReplyMessageService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${telegram.url}")
    private String url;


    public void postText(TelegramReplyMessage message) {
        try {
            HttpHeaders headers = new HttpHeaders();
            ObjectMapper objectMapper = new ObjectMapper();

            String json = objectMapper.writeValueAsString(message);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request =
                    new HttpEntity<String>(json, headers);
            ResponseEntity<String> result = restTemplate.postForEntity(url + "sendMessage", request, String.class);
            System.out.println(result.getBody());
        } catch (Exception e) {
            System.out.println("sendMessage error");
        }
    }


    @Override
    public void sendText(TelegramReplyMessage message) {
        try {
            String params = "?chat_id=" + message.getChat_id() + "&text=" + message.getText();
            restTemplate.getForObject(
                            url + "sendMessage" + params,  String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendImage(TelegramReplyMessage message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map map = new HashMap();
        map.put("chat_id", message.getChat_id());
        map.put("photo", "https://assets.yande.re/data/preview/91/91/91911af29437e86a985f44e9f5095df4.jpg");
        map.put("caption", "");
        map.put("disable_notification", false);
        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> request =  new HttpEntity<String>(json, headers);
        restTemplate.postForEntity(url + "sendPhoto", request, String.class);
    }
}

