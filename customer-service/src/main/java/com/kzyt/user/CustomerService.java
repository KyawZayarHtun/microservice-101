package com.kzyt.user;

import com.kzyt.feignclient.AddressClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final AddressClient addressClient;

    public CustomerDto getCustomerById(Long id) {
        var customer = customerRepo.findById(id).orElseThrow();
        var address = addressClient.getAddressByCustomerId(1L).getBody();
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getAge(),
                address
        );
    }

}
