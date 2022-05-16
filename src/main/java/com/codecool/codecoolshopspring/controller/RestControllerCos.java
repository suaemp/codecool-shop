package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductDTO;
import com.codecool.codecoolshopspring.service.OrderService;
import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    protected ProductService service;

    @Autowired
    public RestControllerCos(OrderService order, ProductService service) {
        this.orderService = order;
        this.service = service;
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

    @GetMapping("/add_to_cart/{productID}")
    public ProductDTO productID(@PathVariable int productID, Model model) {

        Product product = service.getProductById(productID);
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getDefaultPrice(), product.getDefaultCurrency());
        orderService.getOrder(1).addToCart(product);

//        int shoppingCartSize = orderService.getOrder(1).getShoppingCartSize();
//
//        model.addAttribute("cartSize", shoppingCartSize);
        return productDTO;
    }


    @GetMapping("/shopping_cart_size")
    public Integer shoppingCartSize() {

        return orderService.getOrder(1).getShoppingCartSize();
    }

}
