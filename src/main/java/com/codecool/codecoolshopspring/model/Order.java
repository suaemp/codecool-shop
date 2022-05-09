package com.codecool.codecoolshopspring.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Getter
@Setter
public class Order {
    private int id;
    private BigDecimal sum;
    private Map<Product, Integer> customerOrder;
    private List<Product> shoppingCartProducts;
    private CustomerOrderData customerOrderData;

    public Order(int id) {
        this.id = id;
        this.shoppingCartProducts = new ArrayList<>();
        this.customerOrder = new HashMap<>();

    }

    public void addToCart(Product product) {
//        shoppingCartProducts.add(product);

        if (customerOrder.containsKey(product)) {
            customerOrder.put(product, customerOrder.get(product) + 1);
        } else {
            customerOrder.put(product, 1);
        }
    }

    public int getShoppingCartSize() {
        return customerOrder.values().stream().mapToInt(quantity -> quantity).sum();
    }

    public BigDecimal amountOfOrder() {
        sum = BigDecimal.valueOf(0);
        for (Product product : shoppingCartProducts) {
            sum = sum.add(product.getDefaultPrice());
        }
        return sum;
    }


}
