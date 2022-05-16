package com.codecool.codecoolshopspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Currency;

@Data
@AllArgsConstructor
@Entity
public class Product extends BaseModel {

    private BigDecimal defaultPrice;
    private Currency defaultCurrency;
    @Transient
    private ProductCategory productCategory;
    @Transient
    private Supplier supplier;

    public Product(String name, BigDecimal defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);
    }

    public Product() {

    }

    public String getPrice() {
        return this.defaultPrice + " " + this.defaultCurrency.toString();
    }

    public void setPrice(BigDecimal price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        this.supplier.addProduct(this);
    }
}
