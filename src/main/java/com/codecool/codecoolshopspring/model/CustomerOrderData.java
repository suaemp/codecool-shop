package com.codecool.codecoolshopspring.model;


import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderData {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String city;
    private String zipCode;
    private String streetName;
    private String country;


}
