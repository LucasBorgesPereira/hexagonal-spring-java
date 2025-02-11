package com.lucas.hexagonal.adapters.out;

import com.lucas.hexagonal.adapters.out.repository.CustomerRepository;
import com.lucas.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    public DeleteCustomerByIdAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
