package com.test.api.repository;

import java.util.UUID;

import com.test.api.model.Message;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRespository  extends MongoRepository<Message,UUID> {
    
}
