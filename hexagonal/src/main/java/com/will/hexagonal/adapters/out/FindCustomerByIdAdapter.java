package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.repository.CustomerRepository;
import com.will.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.out.FindCustumerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class FindCustomerByIdAdapter implements FindCustumerByIdOutPutPort {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerEntityMapper mapper;
    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = repository.findById(id);
        return customerEntity.map(entity -> mapper.toCustomer(entity));
    }
}
