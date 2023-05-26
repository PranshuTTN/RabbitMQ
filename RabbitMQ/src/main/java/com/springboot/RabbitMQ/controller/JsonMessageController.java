package com.springboot.RabbitMQ.controller;

import com.springboot.RabbitMQ.dto.UserDto;
import com.springboot.RabbitMQ.service.JsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class JsonMessageController {
    @Autowired
    private JsonProducer jsonProducer;

    @GetMapping("/publishing")
    public ResponseEntity<String> sendMessage(@RequestBody UserDto userDto){
        jsonProducer.sendJsonMessage(userDto);
        return ResponseEntity.ok("Json message sent to RabbitMQ!!!!");
    }
}
