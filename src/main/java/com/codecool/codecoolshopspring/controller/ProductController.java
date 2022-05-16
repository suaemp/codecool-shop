package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;

    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Codecool Shop");
        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("products", service.getAllProducts());

        model.addAttribute("suppliers", service.getAllSuppliers());


        return "product/index";
    }

    @GetMapping("/products/{categoryId}")
    public String getFilteredProducts(@PathVariable int categoryId, Model model) {
        model.addAttribute("categoryName", service.getProductCategory(categoryId).getName());

        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("suppliers", service.getAllSuppliers());

        model.addAttribute("products", service.getProductsForCategory(categoryId));

        return "product/filteredProducts";
    }

    @GetMapping("/products/{name}/{supplier}")
    public String getFilteredProductBySupplier(@PathVariable int supplier, Model model) {
        model.addAttribute("supplierName", service.getProductSupplier(supplier).getName());

        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("suppliers", service.getAllSuppliers());
        model.addAttribute("products", service.getAllProductsBySupplier(supplier));

        return "product/filteredProducts";
    }


}
