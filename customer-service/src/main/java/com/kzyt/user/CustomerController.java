package com.kzyt.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
       return ResponseEntity.ok(customerService.getCustomerById(id));
    }

}
