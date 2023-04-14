package com.will.hexagonal.adapters.in.controller.mapper;

import com.will.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.will.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.will.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest request);

    CustomerResponse toCustumerResponse(Customer customer);
}
