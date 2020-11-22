package com.medium.address.controller;

import com.medium.address.model.Address;
import com.medium.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/address", produces = "application/hal+json")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @RequestMapping(value = "/{id}", method = GET)
    public Address getAddressById(@PathVariable("id") final Integer id){
        return addressService.findById(id);
    }
}
