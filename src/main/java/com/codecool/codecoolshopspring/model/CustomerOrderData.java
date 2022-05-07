package com.codecool.codecoolshopspring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerOrderData {
    private int id;
    private int orderId;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String city;
    private String country;

    public CustomerOrderData(int orderId) {
        this.orderId = orderId;
    }

}
