package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.repository.implementation.OrderRepositoryMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private final OrderRepositoryMem orderRepository;

    @Autowired
    public OrderService(OrderRepositoryMem orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(int id) {
        return orderRepository.findById(id).orElseThrow();
    }


}
