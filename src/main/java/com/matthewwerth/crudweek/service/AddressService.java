package com.matthewwerth.crudweek.service;

import com.matthewwerth.crudweek.model.Address;
import com.matthewwerth.crudweek.model.Person;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address getAddressById(Long id);
    Address updateAddress(Address address);
    void deleteAddress(Long id);
}
