package com.medium.client.redis;

import com.medium.client.model.Address;

public interface AddressRedisRepository {
    Address findAddressById(int addressId);
    void deleteAddressById(int addressId);
    void updateOrganizationById(Address address);
    void saveOrganizationById(Address address);
}
