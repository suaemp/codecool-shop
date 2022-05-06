package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService order) {
        this.orderService = order;
    }

    @GetMapping("/shoppingCart")
    public String addToCart(Model model) {
        model.addAttribute("order", orderService.getOrder(1).getShoppingCartProducts());

        BigDecimal totalOrderAmount = orderService.getOrder(1).amountOfOrder();
        model.addAttribute("sum", totalOrderAmount);

        return "shoppingCart.html";
    }

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout.html";
    }
}
