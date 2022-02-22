package com.test.api.controller;

import java.util.List;
import java.util.UUID;

import com.test.api.model.Message;
import com.test.api.repository.MessageRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageRespository respository;

    @GetMapping
    public ResponseEntity<List<Message>> getAll() {

        List<Message> messages = respository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(messages);

    }

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message message) {

        message.setId(UUID.randomUUID());

        Message saveMessage = respository.save(message);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveMessage);

    }

}
