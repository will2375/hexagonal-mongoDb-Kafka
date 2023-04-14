package com.will.hexagonal.adapters.in.controller;

import com.will.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.will.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.will.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.in.InserCustomerInputPort;
import com.will.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.will.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InserCustomerInputPort inserCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    @Autowired
    CustomerMapper mapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = mapper.toCustomer(request);
        inserCustomerInputPort.insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = mapper.toCustumerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @RequestBody CustomerRequest request){
        Customer customer = mapper.toCustomer(request);
        customer.setId(id);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdOutputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
