package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.repository.implementation.OrderRepositoryMem;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderService {
    private final OrderRepositoryMem orderRepository;

    public Order getOrder(int id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
