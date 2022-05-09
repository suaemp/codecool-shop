package com.codecool.codecoolshopspring.repository.implementation;

import com.codecool.codecoolshopspring.model.CustomerOrderData;
import com.codecool.codecoolshopspring.repository.CustomerOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerOrderRepositoryMem implements CustomerOrderRepository {
    private static List<CustomerOrderData> customerDetails = new ArrayList<>();

    @Override
    public void saveUserData(CustomerOrderData customerData) {
        customerDetails.add(customerData);
    }

    @Override
    public List<CustomerOrderData> getAll() {
        return customerDetails;
    }

}
