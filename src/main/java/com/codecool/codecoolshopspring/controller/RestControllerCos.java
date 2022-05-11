package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.OrderService;
import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestControllerCos {

    private OrderService orderService;

    @Autowired
    public RestControllerCos(OrderService order) {
        this.orderService = order;
    }

    @GetMapping("/testuje")
    public List<Integer> integerList() {
        List<Integer> cos = new ArrayList<>(Arrays.asList(1, 2, 3));

        return cos;


    }

    @GetMapping("/add_quantity/{productId}/{newQuantity}")
    public BigDecimal price(@PathVariable int productId, @PathVariable int newQuantity) {


        return orderService.updatedOrder(1, productId, newQuantity);
    }

}
