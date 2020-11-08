package com.medium.address;

import com.medium.address.model.Address;
import com.medium.address.repository.AddressRepository;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataLoader implements ApplicationRunner {
    private final AddressRepository addressRepository;

    public void run(ApplicationArguments args) {
        addressRepository.save(new Address(1, "location"));
    }
}