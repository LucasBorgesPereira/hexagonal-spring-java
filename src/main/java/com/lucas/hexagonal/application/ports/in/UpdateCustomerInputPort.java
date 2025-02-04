package com.lucas.hexagonal.application.ports.in;

import com.lucas.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
