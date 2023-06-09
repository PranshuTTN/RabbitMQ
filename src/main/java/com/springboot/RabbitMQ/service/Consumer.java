package com.springboot.RabbitMQ.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    private void consume(String message){
        log.info("Received message: {}",message);
    }
}
