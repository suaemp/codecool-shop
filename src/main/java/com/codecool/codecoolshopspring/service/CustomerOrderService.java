package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.CustomerOrderData;
import com.codecool.codecoolshopspring.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;


    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;

    }

    public void addCustomerDetails(CustomerOrderData customerData) {
        customerData.setId(new Random().nextInt());
        customerOrderRepository.saveUserData(customerData);

    }

    public List<CustomerOrderData> findAll() {
        return customerOrderRepository.getAll();
    }


}
