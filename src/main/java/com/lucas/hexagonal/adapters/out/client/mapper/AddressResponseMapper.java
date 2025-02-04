package com.lucas.hexagonal.adapters.out.client.mapper;

import com.lucas.hexagonal.adapters.out.client.response.AddressResponse;
import com.lucas.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
