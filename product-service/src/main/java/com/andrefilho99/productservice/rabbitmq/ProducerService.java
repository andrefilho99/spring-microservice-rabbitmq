package com.andrefilho99.productservice.rabbitmq;

import com.andrefilho99.productservice.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    public void produceProductMessage(Product product) {
        String message = String.format(
                "The product %s was just added to our catalog for only %.2f",
                product.getName(),
                product.getPrice());
        rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName, "product.created.email", message);
    }
}
