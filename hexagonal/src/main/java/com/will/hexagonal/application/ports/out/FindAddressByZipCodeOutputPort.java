package com.will.hexagonal.application.ports.out;

import com.will.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
