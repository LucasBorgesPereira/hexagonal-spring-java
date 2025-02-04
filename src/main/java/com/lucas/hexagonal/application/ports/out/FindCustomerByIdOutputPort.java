package com.lucas.hexagonal.application.ports.out;

import com.lucas.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}
