package com.codecool.codecoolshopspring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private BigDecimal sum;
    private List<Product> shoppingCartProducts;

    public Order(int id) {
        this.id = id;
        this.setSum(BigDecimal.valueOf(0));
        this.shoppingCartProducts = new ArrayList<>();

    }

    public List<Product> getShoppingCartProducts() {
        return shoppingCartProducts;
    }


    public void addToCart(Product product) {
        shoppingCartProducts.add(product);
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShoppingCartSize() {
        return shoppingCartProducts.size();
    }

    public BigDecimal amountOfOrder() {
        for (Product product : shoppingCartProducts) {
            sum = sum.add(product.getDefaultPrice());
        }
        return sum;
    }

}
