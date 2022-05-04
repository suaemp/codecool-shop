package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Supplier;
import com.codecool.codecoolshopspring.repository.ProductCategoryRepository;
import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService{
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    private SupplierRepository supplierRepository;


    @Autowired
    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.supplierRepository = supplierRepository;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryRepository.find(categoryId).orElseThrow();
    }

    public List<Product> getProductsForCategory(int categoryId){
        ProductCategory category = productCategoryRepository.find(categoryId).orElseThrow();
        return productRepository.findAllByProductCategory(category);
    }

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public List<Product> getAllProductsBySupplier(int supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow();
        return productRepository.findAllBySupplier(supplier);
    }

    public Supplier getProductSupplier(int supplierId) {
        return supplierRepository.findById(supplierId).orElseThrow();
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElseThrow();

    }


}



