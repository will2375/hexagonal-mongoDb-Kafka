package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.repository.CustomerRepository;
import com.will.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustumerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerEntityMapper mapper;
    @Override
    public void insert(Customer customer) {
        var customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);

    }
}
