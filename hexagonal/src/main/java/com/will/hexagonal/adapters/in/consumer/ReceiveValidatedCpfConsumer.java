package com.will.hexagonal.adapters.in.consumer;

import com.will.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.will.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.will.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper mapper;

    @KafkaListener(topics = "tp-cpf-validated",groupId = "will")
    public void receiveValidationCpfConsumer(CustomerMessage customerMessage) {
        var customer = mapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());

    }
}
