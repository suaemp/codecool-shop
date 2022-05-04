package com.codecool.codecoolshopspring.repository.implementation;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();


    public List<Order> findAll() {
        return orders;
    }


    public Optional<Order> findById(int id) {
        return orders.stream().filter(t -> t.getId() == id).findFirst();
    }

    public void save(Order order) {
        order.setId(orders.size() + 1);
        orders.add(order);
    }


}
