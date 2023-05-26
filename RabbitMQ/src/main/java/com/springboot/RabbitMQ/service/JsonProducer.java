package com.springboot.RabbitMQ.service;

import com.springboot.RabbitMQ.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(UserDto userDto){
        log.info("Json message sent: {}",userDto.toString());
        rabbitTemplate.convertAndSend(exchangeName,routingJsonKey,userDto);
    }
}
