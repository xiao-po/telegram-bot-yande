package com.example.springboot.http.service;

import com.example.springboot.http.TelegramSendService;
import com.example.springboot.model.telegram.reply.TelegramReplyMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TelegramSendServiceImpl implements TelegramSendService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${telegram.url}")
    private String url;


    @Override
    public void postText(TelegramReplyMessage message) {
        try {;

            String result = restTemplate.getForObject(
                    url + "sendMessage?chat_id=" + message.getChat_id() + "&text=" + message.getText() ,
                    String.class);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("sendMessage error");
        }
    }

    @Override
    public void sendImage(TelegramReplyMessage message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map map = new HashMap();
        map.put("chat_id", message.getChat_id());
        map.put("photo", message.getText());
        map.put("caption", "");
        map.put("disable_notification", false);
        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(map);
            HttpEntity<String> request =  new HttpEntity<String>(json, headers);
            restTemplate.postForEntity(url + "sendPhoto", request, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
