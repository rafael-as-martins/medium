package com.medium.client1.service;

import com.medium.client1.model.Client;
import com.medium.client1.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client findById(int id){
        return clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

