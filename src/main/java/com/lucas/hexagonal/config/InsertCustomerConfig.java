package com.lucas.hexagonal.config;

import com.lucas.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.lucas.hexagonal.adapters.out.InsertCustomerAdapter;
import com.lucas.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.lucas.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }

}
