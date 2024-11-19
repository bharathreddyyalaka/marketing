package com.bank.marketing.model;

import java.util.List;

public class CustomerRequests {
    private List<Customer> customers; // List of customers in the request

    // Getters and Setters
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
