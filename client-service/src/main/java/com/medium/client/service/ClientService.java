package com.medium.client.service;

import com.medium.client.model.Address;
import com.medium.client.model.Client;
import com.medium.client.repository.ClientRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final AddressService addressService;

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
            }
    )
    public Client findById(int id){
        return clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
            },
            fallbackMethod = "buildMockAddress"
    )
    public Address findClientAddress(int id){
        Client client = findById(id);
        Optional<Address> address = addressService.getAddressById(client.getAddress());
        return address.orElse(null);
    }

    public Address buildMockAddress(int id){
        log.error("Address Service is taking to long");
        return Address.builder().id(0).name("Default Mock Address - currently external service down").build();
    }

}

