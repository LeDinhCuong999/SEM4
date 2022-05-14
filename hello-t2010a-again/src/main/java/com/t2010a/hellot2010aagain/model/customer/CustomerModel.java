package com.t2010a.hellot2010aagain.model.customer;

import com.t2010a.hellot2010aagain.entity.Customer;

import java.util.List;
public interface CustomerModel {

    Customer create(Customer customer);
    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(String id);

    Customer update(String id, Customer updateCustomer);

    boolean delete(String id);
}
