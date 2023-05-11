package com.andrefilho99.emailservice.rabbitmq;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ProductEmailConsumer {

    @RabbitListener(queues = "product-created-email")
    public void receivedMessage(String message) {
        log.info("Receive message <{}>", message);
        log.info("Send email to all users who assigned to the product newsletter.");
    }
}