package com.springboot.RabbitMQ.service;

import com.springboot.RabbitMQ.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonConsumer {
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    private void consume(UserDto userDto){
        log.info("Received Json message: {}",userDto.toString());
    }
}
