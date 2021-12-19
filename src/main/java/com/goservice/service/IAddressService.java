package com.goservice.service;

import com.goservice.exceptions.AddressNotFoundException;
import com.goservice.model.Address;

import java.util.List;

public interface IAddressService {
    Address addRentalAddress(Address address);
    Address updateAddress(Address address);
    void deleteAddress(int addressId);
    Address getAddressById(int addressId) throws AddressNotFoundException;

    List<Address> getByLocality(String locality) throws AddressNotFoundException;
    List<Address> getByState(String state) throws AddressNotFoundException;
    List<Address> getByCity(String city) throws AddressNotFoundException;
    List<Address> getByZipcode(int zipcode) throws AddressNotFoundException;

}
