package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.DTO.OrderDTO;
import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.DTO.ProductDTO;
import com.codecool.codecoolshopspring.service.OrderService;
import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final OrderService orderService;
    protected ProductService service;

    @Autowired
    public RestController(OrderService order, ProductService service) {
        this.orderService = order;
        this.service = service;
    }

    @GetMapping("/add_quantity/{productId}/{newQuantity}")
    public BigDecimal price(@PathVariable int productId, @PathVariable int newQuantity) {

        return orderService.updatedOrder(1, productId, newQuantity);
    }

    @GetMapping("/add_to_cart/{productID}")
    public ProductDTO productID(@PathVariable int productID) {

        Product product = service.getProductById(productID);
        ProductDTO productDTO = new ProductDTO(product);

        orderService.getOrder(1).addToCart(product);

        return productDTO;
    }


    @GetMapping("/shopping_cart_size")
    public int shoppingCartSize() {
        Order order = orderService.getOrder(1);
        OrderDTO orderDTO = new OrderDTO(order);

        return orderDTO.getShoppingCartSize();
    }

}
