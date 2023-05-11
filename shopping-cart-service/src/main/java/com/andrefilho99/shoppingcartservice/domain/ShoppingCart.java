package com.andrefilho99.shoppingcartservice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ShoppingCart")
public class ShoppingCart implements Serializable {

    private String id;
    private List<ShoppingCartItem> items;
    private Double total;

    public void addItem(ShoppingCartItem item) {
        items.add(item);
    }
}
