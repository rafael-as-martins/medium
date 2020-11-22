package com.medium.address.service;

import com.medium.address.model.Address;
import com.medium.address.repository.AddressRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address findById(Integer id){
        Optional<Address> address = addressRepository.findById(id);
        return (address.isPresent())? address.get() : null;
    }
}

