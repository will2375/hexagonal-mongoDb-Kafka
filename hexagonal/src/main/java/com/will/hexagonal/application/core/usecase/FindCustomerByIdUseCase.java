package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.out.FindCustumerByIdOutPutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustumerByIdOutPutPort findCustumerByIdOutPutPort;

    public FindCustomerByIdUseCase(FindCustumerByIdOutPutPort findCustumerByIdOutPutPort) {
        this.findCustumerByIdOutPutPort = findCustumerByIdOutPutPort;
    }

    @Override
    public Customer find(String id) {
        return findCustumerByIdOutPutPort.find(id).orElseThrow(() -> new RuntimeException("Custumer not found"));
    }
}
