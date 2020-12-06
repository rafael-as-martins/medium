package com.medium.address.service;

import com.medium.address.model.Address;
import com.medium.address.repository.AddressRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address findById(Integer id){
        randomlySleep();
        Optional<Address> address = addressRepository.findById(id);
        return (address.isPresent())? address.get() : null;
    }

    private void randomlySleep(){
        try {
            int random = ThreadLocalRandom.current().nextInt(4);
            log.info(format("Random chosen: %d", random));
            if (random == 3) {
                Thread.sleep(7000);
            }
        }catch (InterruptedException e){
            log.error(e.getMessage(), e);
        }
    }
}

