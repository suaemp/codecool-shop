package com.codecool.codecoolshopspring.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> shoppingCartProducts;

    public Order(int id) {
        this.id = id;
        this.shoppingCartProducts = new ArrayList<>();
    }

    public List<Product> getShoppingCartProducts() {
        return shoppingCartProducts;
    }


    public void addToCart(Product product) {
        shoppingCartProducts.add(product);
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
}
