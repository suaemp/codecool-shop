package com.codecool.codecoolshopspring.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Order {
    private int id;
    private Map<Product, Integer> customerOrder;
    private CustomerOrderData customerOrderData;

    public Order(int id) {
        this.id = id;
        this.customerOrder = new HashMap<>();

    }

    public void addToCart(Product product) {
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
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : customerOrder.keySet()) {
            BigDecimal itemCost = product.getDefaultPrice().multiply(BigDecimal.valueOf(customerOrder.get(product)));
            sum = sum.add(itemCost);
        }
        return sum;
    }


    public void update(int productId, int newQuantity) {
        for (Product product : customerOrder.keySet()) {
            if(product.getId() == productId) {
                customerOrder.put(product, newQuantity);
            }
        }
    }


    public void removeProduct(Product product) {
        customerOrder.remove(product);
    }
}
