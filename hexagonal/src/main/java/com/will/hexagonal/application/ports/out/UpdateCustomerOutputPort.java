package com.will.hexagonal.application.ports.out;

import com.will.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
