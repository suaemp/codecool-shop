package com.codecool.codecoolshopspring.model.DTO;

import com.codecool.codecoolshopspring.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private BigDecimal defaultPrice;
    private Currency defaultCurrency;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.defaultPrice = product.getDefaultPrice();
        this.defaultCurrency = product.getDefaultCurrency();

    }

}
