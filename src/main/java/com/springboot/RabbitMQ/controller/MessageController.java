package com.springboot.RabbitMQ.controller;

import com.springboot.RabbitMQ.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private Producer producer;

    @GetMapping("/publishing/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ!!!!");
    }
}
