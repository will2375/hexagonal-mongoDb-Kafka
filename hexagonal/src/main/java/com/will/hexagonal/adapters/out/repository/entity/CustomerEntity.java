package com.will.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "custumers")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity address;
    private String cpf;
    private Boolean isValidCPf;

}
