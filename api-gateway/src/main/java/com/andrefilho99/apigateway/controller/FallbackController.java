package com.andrefilho99.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/product-service-fallback")
    public ResponseEntity productServiceFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("PRODUCT-SERVICE is down!");
    }

    @RequestMapping("/shopping-cart-service-fallback")
    public ResponseEntity shoppingCartServiceFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("SHOPPING-CART-SERVICE is down!");
    }
}
