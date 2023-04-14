package com.will.hexagonal.application.config;

import com.will.hexagonal.adapters.out.FIndAddressByZipCodeAdapter;
import com.will.hexagonal.adapters.out.repository.UpdateCustomerAdapter;
import com.will.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.will.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FIndAddressByZipCodeAdapter fIndAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,fIndAddressByZipCodeAdapter,updateCustomerAdapter);
    }
}
