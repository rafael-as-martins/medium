package com.medium.client.service;

import com.medium.client.model.Address;
import com.medium.client.redis.AddressRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpMethod.GET;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {
    private static final String GATEWAY_ENDPOINT = "http://gateway-service:8282";
    private static final String ADDRESS_CONTEXT = GATEWAY_ENDPOINT + "/address";
    private static final String ADDRESS_GET_BY_ID = ADDRESS_CONTEXT + "/{id}";

    private final RestTemplate restTemplate;
    private final AddressRedisRepository addressRedisRepository;

    public Optional<Address> getAddressById(int id){

        Address cachedAddress = getCachedAddress(id);

        if(nonNull(cachedAddress)){
            return Optional.of(cachedAddress);
        }

        ResponseEntity<Address> address = restTemplate.exchange(ADDRESS_GET_BY_ID, GET, null, Address.class, id);

        if(nonNull(address.getBody())){
            cacheAddress(address.getBody());
        }

        return Optional.ofNullable(address.getBody());
    }

    private Address getCachedAddress(int id){
        Address address = null;
        try{
            address = addressRedisRepository.findAddressById(id);
        }catch (Exception e){
            log.warn(format("No address was yet cached with the given id : %d!", id));
        }
        return address;
    }

    private void cacheAddress(Address addres){
        try{
            addressRedisRepository.saveOrganizationById(addres);
        }catch (Exception e){
            log.error(format("Unable to store the given address : %s!", addres));
        }
    }

}
