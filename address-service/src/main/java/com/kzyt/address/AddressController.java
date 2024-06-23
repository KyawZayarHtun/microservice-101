package com.kzyt.address;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("address/{id}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findAddressById(id));
    }

}
