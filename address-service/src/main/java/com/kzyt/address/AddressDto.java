package com.kzyt.address;

public record AddressDto(
        Long id,
        String street,
        String state,
        String city,
        String country
) {
}
