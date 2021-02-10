package com.matthewwerth.crudweek.service;

import com.matthewwerth.crudweek.model.Address;
import com.matthewwerth.crudweek.model.Person;
import com.matthewwerth.crudweek.repository.AddressRepository;
import com.matthewwerth.crudweek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        Optional<Address> addressDB = this.addressRepository.findById(id);
        return addressDB.orElse(null);
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> adds = this.addressRepository.findById(address.getId());

        if(adds.isPresent()){
            Address addUpdate = adds.get();
            addUpdate.setId(address.getId());
            addUpdate.setStreet(address.getStreet());
            addUpdate.setNumber(address.getNumber());
            addUpdate.setState(address.getState());
            addressRepository.save(address);
            return addUpdate;
        }
        return null;
    }

    @Override
    public void deleteAddress(Long id) {
        Optional<Address> addDB = this.addressRepository.findById(id);
        addDB.ifPresent(person -> this.addressRepository.delete(person));
    }
}
