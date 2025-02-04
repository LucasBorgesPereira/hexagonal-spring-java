package com.lucas.hexagonal.application.ports.out;

import com.lucas.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipcode);

}
