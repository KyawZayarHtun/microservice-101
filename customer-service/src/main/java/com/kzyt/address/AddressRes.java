package com.kzyt.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRes {

    private Long id;
    private String street;
    private String state;
    private String city;
    private String country;

}
