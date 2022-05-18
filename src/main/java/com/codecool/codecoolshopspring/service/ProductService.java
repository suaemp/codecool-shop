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
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;


    @Autowired
    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.supplierRepository = supplierRepository;
    }

    public ProductCategory getProductCategory(int categoryId) {
        return productCategoryRepository.findById(categoryId).orElseThrow();
    }

    public List<Product> getProductsForCategory(int categoryId) {
        ProductCategory category = productCategoryRepository.findById(categoryId).orElseThrow();
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

    public Product getProductById(int productID) {
        return productRepository.findById(productID).orElseThrow();

    }

    public void deleteProduct(int productID) {
      productRepository.deleteById(productID);
    }


}



