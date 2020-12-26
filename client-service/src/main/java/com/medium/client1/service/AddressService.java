package com.medium.client1.service;

import com.medium.client1.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpMethod.GET;

@Service
@RequiredArgsConstructor
public class AddressService {
    private static final String GATEWAY_ENDPOINT = "http://gateway-service:8282";
    private static final String ADDRESS_CONTEXT = GATEWAY_ENDPOINT + "/address";
    private static final String ADDRESS_GET_BY_ID = ADDRESS_CONTEXT + "/{id}";

    private final RestTemplate restTemplate;

    public Optional<Address> getAddressById(int id){
        ResponseEntity<Address> address = restTemplate.exchange(ADDRESS_GET_BY_ID, GET, null, Address.class, id);
        return Optional.ofNullable(address.getBody());
    }
}
