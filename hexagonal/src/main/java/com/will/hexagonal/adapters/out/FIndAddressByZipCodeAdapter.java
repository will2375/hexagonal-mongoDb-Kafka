package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.will.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.will.hexagonal.application.core.domain.Address;
import com.will.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FIndAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;
    @Override
    public Address find(String zipCode) {
        var addresResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addresResponse);
    }
}
