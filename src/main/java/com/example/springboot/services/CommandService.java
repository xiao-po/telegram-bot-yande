package com.example.springboot.services;

import com.example.springboot.model.command.CommandResponse;

public interface CommandService {
    CommandResponse dispatch(String commandText);

    void uploadImage();

    void banTag();
}
