package com.kzyt.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;

    public AddressDto findAddressById(Long id) {
        var address = addressRepo.findById(id).orElseThrow();
        return new AddressDto(
                address.getId(),
                address.getStreet(),
                address.getState(),
                address.getCity(),
                address.getCountry()
        );
    }

}
