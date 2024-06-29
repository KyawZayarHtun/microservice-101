package com.kzyt.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street, state, city, country;

    @Column(name = "customer_id")
    private Long customerId;

}
