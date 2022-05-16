package com.codecool.codecoolshopspring.model.DTO;

import com.codecool.codecoolshopspring.model.Order;

public class OrderDTO {
    private final int shoppingCartSize;

    public OrderDTO(Order order) {
        this.shoppingCartSize = order.getShoppingCartSize();

    }

    public int getShoppingCartSize() {
        return shoppingCartSize;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "shoppingCartSize=" + shoppingCartSize +
                '}';
    }
}
