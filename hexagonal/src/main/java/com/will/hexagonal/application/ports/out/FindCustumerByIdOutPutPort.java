package com.will.hexagonal.application.ports.out;

import com.will.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustumerByIdOutPutPort {

    Optional<Customer> find(String id);

}
