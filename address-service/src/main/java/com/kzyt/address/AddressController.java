package com.kzyt.address;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("address/{id}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable Long id) {
        System.out.println("Call = ");
        return ResponseEntity.ok(addressService.findAddressById(id));
    }

    @GetMapping("addresses")
    public ResponseEntity<List<AddressDto>> findAllAddresses() {
        return ResponseEntity.ok(addressService.findAllAddress());
    }

}
