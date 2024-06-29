package com.kzyt.user;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    // private final DiscoveryClient discoveryClient;
    private final LoadBalancerClient loadBalancerClient;

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        // Get from Eureka client directly
        /*
            var instances = discoveryClient.getInstances("address-service");
        */

        // Get with load balancer using eureka
        /*
            var instance = loadBalancerClient.choose("address-service");
            System.out.println("uri = " + instance.getUri().toString());
            System.out.println("context path = " + instance.getMetadata().get("context-path"));
            System.out.println("from = " + instance.getMetadata().get("from"));
        */

        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> cusDto = customerService.getCustomers();
        return ResponseEntity.ok(cusDto);
    }

}
