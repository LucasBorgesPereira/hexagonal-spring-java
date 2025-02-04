package com.lucas.hexagonal.adapters.out;

import com.lucas.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.lucas.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.lucas.hexagonal.application.core.domain.Address;
import com.lucas.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(
            FindAddressByZipCodeClient findAddressByZipCodeClient,
            AddressResponseMapper addressResponseMapper
    ) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipcode) {
        var addressResponse = findAddressByZipCodeClient.find(zipcode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
