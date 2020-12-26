package com.medium.client1.controller;

import com.medium.client1.model.Address;
import com.medium.client1.model.Client;
import com.medium.client1.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(path = "/client", produces = "application/hal+json")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable("id") final Integer id, HttpServletRequest request){

        log.info("CORRELATION ID:::: " + request.getHeader("correlation-id"));
        return clientService.findById(id);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Address getClientAddress(@PathVariable("id") final Integer id){
        return clientService.findClientAddress(id);
    }
}
