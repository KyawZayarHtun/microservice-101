package com.kzyt.feignclient;

import com.kzyt.address.AddressRes;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// http://192.168.1.7:8081/address-app/api/address/1

@FeignClient(name = "address-service", path = "address-app/api")
public interface AddressClient {

    @GetMapping("address/{id}")
    @LoadBalanced
    ResponseEntity<AddressRes> getAddressByCustomerId(@PathVariable Long id);

    @GetMapping("addresses")
    @LoadBalanced
    ResponseEntity<List<AddressRes>> getAddresses();

}
