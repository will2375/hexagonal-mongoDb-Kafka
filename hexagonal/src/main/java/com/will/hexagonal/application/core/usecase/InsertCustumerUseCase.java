package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.InserCustomerInputPort;
import com.will.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.will.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.will.hexagonal.application.ports.out.SendCpfValidationOutPutPort;

public class InsertCustumerUseCase implements InserCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfValidationOutPutPort sendCpfValidationOutPutPort;

    public  InsertCustumerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                  InsertCustomerOutputPort insertCustomerOutputPort, SendCpfValidationOutPutPort sendCpfValidationOutPutPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfValidationOutPutPort = sendCpfValidationOutPutPort;
    }
    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfValidationOutPutPort.send(customer.getCpf());

    }
}
