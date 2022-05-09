package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.CustomerOrderData;

import java.util.List;

public interface CustomerOrderRepository {

    void saveUserData(CustomerOrderData customerData);
    List<CustomerOrderData> getAll();

}
