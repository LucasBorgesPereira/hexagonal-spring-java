package com.lucas.hexagonal.adapters.out;

import com.lucas.hexagonal.adapters.out.repository.CustomerRepository;
import com.lucas.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.lucas.hexagonal.application.core.domain.Customer;
import com.lucas.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
