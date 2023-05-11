package com.andrefilho99.shoppingcartservice.controller;

import com.andrefilho99.shoppingcartservice.domain.ShoppingCart;
import com.andrefilho99.shoppingcartservice.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<Iterable<ShoppingCart>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> findById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.findById(id));
    }

//    @PostMapping("/{id}/add-item/{itemId}")
//    public ResponseEntity<ShoppingCart> addItem(@PathVariable String id, @PathVariable Long itemId) {
//        return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.addItem(id, itemId));
//    }
}
