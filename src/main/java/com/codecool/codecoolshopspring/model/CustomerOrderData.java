package com.codecool.codecoolshopspring.model;

public class CustomerOrderData {
    private int id;
    private int orderId;
    private String name;
    private String surname;
    private String email;
    private int number;
    private String city;
    private String country;

    public CustomerOrderData(int id, String name, String surname, String email, int number, String city, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.city = city;
        this.country = country;
    }

    public CustomerOrderData(int orderId) {
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}