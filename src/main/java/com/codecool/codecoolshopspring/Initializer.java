package com.codecool.codecoolshopspring;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.repository.ProductCategoryRepository;
import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.repository.SupplierRepository;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.Supplier;
import com.codecool.codecoolshopspring.repository.implementation.OrderRepositoryMem;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class Initializer {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;
    private OrderRepositoryMem orderRepository;

    public Initializer(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, SupplierRepository supplierRepository, OrderRepositoryMem orderRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.supplierRepository = supplierRepository;
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void init() {
        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierRepository.save(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Laptops and tablets");
        supplierRepository.save(lenovo);
        Supplier apple = new Supplier("Apple", "Laptops and phones");
        supplierRepository.save(apple);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet laptop, commonly shortened to tablet, is a thin, flat mobile laptop with a touchscreen display.");
        productCategoryRepository.save(tablet);
        ProductCategory laptop = new ProductCategory("Laptop", "Hardware", "A small, portable personal laptop (PC) with a screen and alphanumeric keyboard.");
        productCategoryRepository.save(laptop);

        //setting up products and printing it
//        Product product = productRepository.save(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        Product product = new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon);
        productRepository.save(product);
        productRepository.save(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productRepository.save(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        productRepository.save(new Product("Macbook Pro", new BigDecimal("500"), "USD", "The MacBook Pro is a line of Macintosh notebook computers by by Apple Inc. ", laptop, apple));

        Order order = new Order(1);

//        order.addToCart(product);
        orderRepository.save(order);
    }
}
