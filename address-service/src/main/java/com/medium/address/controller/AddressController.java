package com.medium.address.controller;

import com.medium.address.model.Address;
import com.medium.address.service.AddressService;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping(path = "/address", produces = "application/hal+json")
public class AddressController {
    private final AddressService addressService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getClient(@PathVariable("id") final Integer id){
        return addressService.findById(id);
    }
}
