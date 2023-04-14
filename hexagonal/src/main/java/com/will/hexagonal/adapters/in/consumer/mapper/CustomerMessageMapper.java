package com.will.hexagonal.adapters.in.consumer.mapper;

import com.will.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.will.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
