package com.kzyt.user;

import com.kzyt.address.AddressRes;

public record CustomerDto(
        Long id,
        String name,
        String age,
        AddressRes address
) {
}
