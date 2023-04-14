package com.will.hexagonal.application.config;

import com.will.hexagonal.adapters.out.FIndAddressByZipCodeAdapter;
import com.will.hexagonal.adapters.out.InsertCustumerAdapter;
import com.will.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.will.hexagonal.application.core.usecase.InsertCustumerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustumerUseCase insertCustumerUseCase(
            FIndAddressByZipCodeAdapter fIndAddressByZipCodeAdapter,
            InsertCustumerAdapter insertCustumerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter) {
        return new InsertCustumerUseCase(fIndAddressByZipCodeAdapter, insertCustumerAdapter, sendCpfValidationAdapter);

    }
}
