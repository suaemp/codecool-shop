package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.repository.implementation.OrderRepositoryMem;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class OrderService {
    private final OrderRepositoryMem orderRepository;

    public Order getOrder(int id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public BigDecimal updatedOrder(int i, int productId, int newQuantity) {
       Order order =  orderRepository.findById(i).orElseThrow();

       order.update(productId, newQuantity);

        return order.amountOfOrder();
    }
}
