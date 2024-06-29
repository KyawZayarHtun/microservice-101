package com.kzyt.user;

import com.kzyt.address.AddressRes;
import com.kzyt.feignclient.AddressClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<CustomerDto> getCustomers() {
        var customers = customerRepo.findAll();
        var addresses = addressClient.getAddresses().getBody();

        return customers.stream()
                .map(cus -> {
                    assert addresses != null;
                    var address = addresses.stream()
                            .filter(addressRes -> addressRes.getId().equals(cus.getId()))
                            .findAny()
                            .orElse(new AddressRes());
                    return new CustomerDto(cus.getId(), cus.getName(), cus.getAge(), address);
                })
                .toList();
    }
}
