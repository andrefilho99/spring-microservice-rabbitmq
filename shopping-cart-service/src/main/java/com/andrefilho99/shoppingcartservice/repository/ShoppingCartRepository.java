package com.andrefilho99.shoppingcartservice.repository;

import com.andrefilho99.shoppingcartservice.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, String> {
}