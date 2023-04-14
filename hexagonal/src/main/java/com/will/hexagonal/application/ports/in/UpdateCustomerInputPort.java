package com.will.hexagonal.application.ports.in;

import com.will.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void  update(Customer customer, String zipCode);
}
