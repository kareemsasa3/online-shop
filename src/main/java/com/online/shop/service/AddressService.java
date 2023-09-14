package com.online.shop.service;

import com.online.shop.entity.Address;
import com.online.shop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address) {
        // implement validation or business logic if needed
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));
    }

    public Address updateAddress(Address address) {
        // implement validation or business logic if needed
        return addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    // other methods as needed
}
