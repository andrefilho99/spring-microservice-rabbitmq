package com.andrefilho99.productservice.service;

import com.andrefilho99.productservice.domain.Product;
import com.andrefilho99.productservice.rabbitmq.ProducerService;
import com.andrefilho99.productservice.rabbitmq.RabbitConfig;
import com.andrefilho99.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProducerService producerService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found."));
    }

    public Product create(Product product) {
        producerService.produceProductMessage(product);
        return productRepository.save(product);
    }
}
