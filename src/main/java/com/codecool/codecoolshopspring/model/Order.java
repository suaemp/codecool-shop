package com.codecool.codecoolshopspring.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {
    private int id;
    private BigDecimal sum;
    private List<Product> shoppingCartProducts;

    public Order(int id) {
        this.id = id;
        this.shoppingCartProducts = new ArrayList<>();

    }

    public void addToCart(Product product) {
        shoppingCartProducts.add(product);
    }

    public int getShoppingCartSize() {
        return shoppingCartProducts.size();
    }

    public BigDecimal amountOfOrder() {
        sum = BigDecimal.valueOf(0);
        for (Product product : shoppingCartProducts) {
            sum = sum.add(product.getDefaultPrice());
        }
        return sum;
    }

}
