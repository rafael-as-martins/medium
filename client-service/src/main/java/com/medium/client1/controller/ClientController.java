package com.medium.client1.controller;

import com.medium.client1.model.Client;
import com.medium.client1.service.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping(path = "/client", produces = "application/hal+json")
public class ClientController {

    private final ClientService clientService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable("id") final Integer id){
        return clientService.findById(id);
    }
}
