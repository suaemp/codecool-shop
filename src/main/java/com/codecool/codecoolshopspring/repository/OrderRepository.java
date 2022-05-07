package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> findAll();
    Optional<Order> findById(int id);
    void save(Order order);
}
