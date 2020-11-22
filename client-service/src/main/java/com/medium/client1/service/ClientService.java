package com.medium.client1.service;

import com.medium.client1.model.Address;
import com.medium.client1.model.Client;
import com.medium.client1.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final AddressService addressService;

    public Client findById(int id){
        return clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Address findClientAddress(int addressId){
        Optional<Address> address = addressService.getAddressById(addressId);
        return (address.isPresent())? address.get() : null;
    }
}

