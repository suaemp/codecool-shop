package com.codecool.codecoolshopspring.repository.implementation;

import com.codecool.codecoolshopspring.model.CustomerOrderData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerOrderRepository {
    private static List<CustomerOrderData> customerDetails = new ArrayList<>();

    public void saveUserData(CustomerOrderData customerData) {
        customerDetails.add(customerData);
    }

    public List<CustomerOrderData> getAll() {
        return customerDetails;
    }

}
