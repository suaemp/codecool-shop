package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.CustomerOrderData;
import com.codecool.codecoolshopspring.service.CustomerOrderService;
import com.codecool.codecoolshopspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class OrderController {

    private OrderService orderService;
    private CustomerOrderService customerOrderService;

    @Autowired
    public OrderController(OrderService order, CustomerOrderService customerOrderService) {
        this.orderService = order;
        this.customerOrderService = customerOrderService;
    }

    @GetMapping("/shoppingCart")
    public String addToCart(Model model) {
        model.addAttribute("order", orderService.getOrder(1).getShoppingCartProducts());

        BigDecimal totalOrderAmount = orderService.getOrder(1).amountOfOrder();
        model.addAttribute("sum", totalOrderAmount);

        return "shoppingCart.html";
    }

    @GetMapping("/checkout")
    public String checkoutPage(Model model) {
        int orderId = orderService.getOrder(1).getId();
        model.addAttribute("customerData", new CustomerOrderData(orderId));

        return "checkout.html";
    }

    @PostMapping("/add_customer_details")
    public String addCustomerDetails(@ModelAttribute CustomerOrderData customerData) {
        customerOrderService.addCustomerDetails(customerData);
//        System.out.println(customerOrderService);
        return "redirect:/";
    }

    @GetMapping("/payment")
    public String paymentPage() {
        return "payment.html";
    }
}
