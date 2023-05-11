package com.andrefilho99.shoppingcartservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItem {

    private String name;
    private Integer quantity;
    private Double price;
}
