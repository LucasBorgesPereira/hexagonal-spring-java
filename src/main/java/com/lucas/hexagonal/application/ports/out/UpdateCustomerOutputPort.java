package com.lucas.hexagonal.application.ports.out;

import com.lucas.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
