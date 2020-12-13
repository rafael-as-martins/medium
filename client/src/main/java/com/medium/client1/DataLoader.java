package com.medium.client1;

import com.medium.client1.model.Client;
import com.medium.client1.repository.ClientRepository;
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
        clientRepository.save(new Client(1, "name", 22, "address"));
    }
}