package com.medium.address.service;

import com.medium.address.model.Address;
import com.medium.address.repository.AddressRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class AddressService {

    private AddressRepository addressRepository;

    public Address findById(Integer id){
        return addressRepository.findOne(id);
    }

}

