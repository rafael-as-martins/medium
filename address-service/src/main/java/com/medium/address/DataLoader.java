package com.medium.address;

import com.medium.address.model.Address;
import com.medium.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    private final AddressRepository addressRepository;

    public void run(ApplicationArguments args) {
        addressRepository.save(new Address(1, "location"));
    }
}