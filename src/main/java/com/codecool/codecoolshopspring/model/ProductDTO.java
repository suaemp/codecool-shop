package com.codecool.codecoolshopspring.model;

import java.math.BigDecimal;
import java.util.Currency;


public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private BigDecimal defaultPrice;
    private Currency defaultCurrency;


    public ProductDTO(int id, String name, String description, BigDecimal defaultPrice, Currency defaultCurrency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = defaultCurrency;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
    }

    public ProductDTO() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
}
