package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.service.OrderService;
import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private ProductService service;
    private OrderService orderService;

    @Autowired
    public ProductController(ProductService service, OrderService order) {
        this.service = service;
        this.orderService = order;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Codecool Shop");
        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("products", service.getAllProducts());

        model.addAttribute("suppliers", service.getAllSuppliers());
//        System.out.println(service.getAllProducts());

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
//        model.addAttribute("product", new Product("tablet","ahbsahbd"));
        return "product/filteredProducts";
    }

    @GetMapping("/add_to_cart/{productId}")
    public String add(@PathVariable int productId, Model model) {
        System.out.println(orderService.getOrder(1).getShoppingCartProducts());
        Product product = service.getProductById(productId);
//        System.out.println(service.getProductById(productId));
        orderService.getOrder(1).addToCart(product);
        System.out.println(orderService.getOrder(1).getShoppingCartProducts());

        return "redirect:/";
    }

    @GetMapping("/shoppingCart")
    public String addToCart(Model model) {
        model.addAttribute("order", orderService.getOrder(1).getShoppingCartProducts());
        System.out.println(orderService.getOrder(1));
        return "product/shoppingCart";
    }

}
