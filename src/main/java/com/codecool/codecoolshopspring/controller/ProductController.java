package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

        return "product/index";
    }

//    @GetMapping("/Tablets")
//    public String displayTabletProducts(Model model) {
//        model.addAttribute("title", "Tablet category");
//        model.addAttribute("choosenCategory", service.getProductCategory(1));
//        model.addAttribute("allCategories", service.getAllProductCategories());
//        model.addAttribute("products", service.getProductsForCategory(1));
//
//        return "product/tablets";
//    }
//
//    @GetMapping("/Laptops")
//    public String displayLaptopProducts(Model model) {
//        model.addAttribute("title", "Laptop category");
//        model.addAttribute("choosenCategory", service.getProductCategory(2));
//        model.addAttribute("allCategories", service.getAllProductCategories());
//        model.addAttribute("products", service.getProductsForCategory(2));
//
//        return "product/laptops";
//    }

//        @GetMapping("/products/{categoryId}")
//        public String display(@PathVariable String categoryId) {
//
//        }
//    }
    @GetMapping("/products/{categoryId}")
    public String getFilteredProducts(@PathVariable String categoryId, Model model) {
        model.addAttribute("choosenCategory", service.getProductCategory(Integer.parseInt(categoryId)));
        model.addAttribute("allCategories", service.getAllProductCategories());
        model.addAttribute("products", service.getProductsForCategory(Integer.parseInt(categoryId)));
        return "product/tablet";
    }
}
