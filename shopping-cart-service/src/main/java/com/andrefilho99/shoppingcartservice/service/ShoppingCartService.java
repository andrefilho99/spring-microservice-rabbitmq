package com.andrefilho99.shoppingcartservice.service;

import com.andrefilho99.shoppingcartservice.domain.ShoppingCart;
import com.andrefilho99.shoppingcartservice.domain.ShoppingCartItem;
import com.andrefilho99.shoppingcartservice.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public Iterable<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart findById(String id) {
        return shoppingCartRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Shopping cart not found."));
    }

    public ShoppingCart createWithFirstItem(ShoppingCartItem item) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Double totalItemPrice = item.getPrice() * item.getQuantity();

        shoppingCart.addItem(item);
        shoppingCart.setTotal(totalItemPrice);
        return shoppingCartRepository.save(shoppingCart);
    }

//    public ShoppingCart addItem(String id, Long Id) {
//        ShoppingCartItem item =
//        ShoppingCart shoppingCart = findById(id);
//        Double totalItemPrice = item.getPrice() * item.getQuantity();
//        Double totalCartPrice = shoppingCart.getTotal();
//
//        shoppingCart.addItem(item);
//        shoppingCart.setTotal(totalCartPrice+totalItemPrice);
//        return shoppingCartRepository.save(shoppingCart);
//    }
}
