package com.test.api.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document("message")
public class Message {

    @Id
    private  UUID id;


    private String message;
    
}
