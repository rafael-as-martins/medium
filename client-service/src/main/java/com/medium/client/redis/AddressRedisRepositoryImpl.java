package com.medium.client.redis;

import com.medium.client.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@RequiredArgsConstructor
public class AddressRedisRepositoryImpl implements AddressRedisRepository{

    private static final String REDIS_ENTITY = "address";

    private final RedisTemplate<String, Address> redisTemplate;

    private HashOperations<String, Integer, Address> hashOperations;

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Address findAddressById(int addressId) {
        return hashOperations.get(REDIS_ENTITY, addressId);
    }

    @Override
    public void deleteAddressById(int addressId) {
        hashOperations.delete(REDIS_ENTITY, addressId);
    }

    @Override
    public void updateOrganizationById(Address address) {
        hashOperations.put(REDIS_ENTITY, address.getId(), address);
    }

    @Override
    public void saveOrganizationById(Address address) {
        hashOperations.put(REDIS_ENTITY, address.getId(), address);
    }
}
