package com.kzyt.address;

public record AddressRes(
        Long id,
        String street,
        String state,
        String city,
        String country
) {
}
