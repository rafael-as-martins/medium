package com.medium.client;

import com.medium.client.model.Client;
import com.medium.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final ClientRepository clientRepository;

    @Autowired
    public DataLoader(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public void run(ApplicationArguments args) {
        clientRepository.save(new Client(1, "name1", 22, "address1"));
        clientRepository.save(new Client(2, "name2", 23, "address2"));
        clientRepository.save(new Client(3, "name3", 24, "address3"));
        clientRepository.save(new Client(4, "name4", 25, "address4"));
        clientRepository.save(new Client(5, "name5", 26, "address5"));
        clientRepository.save(new Client(6, "name6", 27, "address6"));

    }
}