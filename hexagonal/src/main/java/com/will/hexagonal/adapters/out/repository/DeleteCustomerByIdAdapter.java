package com.will.hexagonal.adapters.out.repository;

import com.will.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository repository;
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
