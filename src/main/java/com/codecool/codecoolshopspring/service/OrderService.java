package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.repository.implementation.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(int id) {
        return orderRepository.findById(id).orElseThrow();
    }

//    public int getOrderSize(int id) {
//        return orderRepository.orderSize(id);
//    }

}
