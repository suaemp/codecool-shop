package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Codecool Shop");
        model.addAttribute("category", service.getAllProductCategories());
        model.addAttribute("products", service.getAllProducts());
        System.out.println(service.getAllProducts());
        return "product/index";
    }

    @GetMapping("/Tablet")
    public String displayTabletProducts(Model model){
        model.addAttribute("title", "Tablet category");
        model.addAttribute("choosenCategory", service.getProductCategory(1));
        model.addAttribute("allCategories", service.getAllProductCategories());
        model.addAttribute("products", service.getProductsForCategory(1));

        return "product/tablets";
    }
}
