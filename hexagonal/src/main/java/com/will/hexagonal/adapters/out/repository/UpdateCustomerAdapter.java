package com.will.hexagonal.adapters.out.repository;

import com.will.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerEntityMapper mapper;
    @Override
    public void update(Customer customer) {
        var customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);

    }
}
