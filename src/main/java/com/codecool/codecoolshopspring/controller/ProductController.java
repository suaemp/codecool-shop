package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.OrderService;
import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService service;
    private final OrderService orderService;

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

        int shoppingCartSize = orderService.getOrder(1).getShoppingCartSize();
        model.addAttribute("cartSize", shoppingCartSize);

        return "product/index";
    }

    @GetMapping("/products/{categoryId}")
    public String getFilteredProducts(@PathVariable int categoryId, Model model) {
        model.addAttribute("categoryName", service.getProductCategory(categoryId).getName());

        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("suppliers", service.getAllSuppliers());

        model.addAttribute("products", service.getProductsForCategory(categoryId));

        int shoppingCartSize = orderService.getOrder(1).getShoppingCartSize();
        model.addAttribute("cartSize", shoppingCartSize);
        return "product/filteredProducts";
    }

    @GetMapping("/products/{name}/{supplier}")
    public String getFilteredProductBySupplier(@PathVariable int supplier, Model model) {
        model.addAttribute("supplierName", service.getProductSupplier(supplier).getName());

        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("suppliers", service.getAllSuppliers());
        model.addAttribute("products", service.getAllProductsBySupplier(supplier));

        int shoppingCartSize = orderService.getOrder(1).getShoppingCartSize();
        System.out.println(shoppingCartSize + "wielkość koszyka");
        model.addAttribute("cartSize", shoppingCartSize);

        return "product/filteredProducts";
    }

//    @GetMapping("/add_to_cart/{productId}")
//    public String add(@PathVariable int productId, Model model) {
//        Product product = service.getProductById(productId);
//
//        orderService.getOrder(1).addToCart(product);
//
//        return "redirect:/";
//    }


}
