package com.lucas.hexagonal.application.ports.in;

import com.lucas.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
