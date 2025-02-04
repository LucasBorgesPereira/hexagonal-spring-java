package com.lucas.hexagonal.adapters.out;

import com.lucas.hexagonal.adapters.out.repository.CustomerRepository;
import com.lucas.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.lucas.hexagonal.application.core.domain.Customer;
import com.lucas.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
