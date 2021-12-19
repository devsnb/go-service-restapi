package com.goservice.service;

import com.goservice.exceptions.AddressNotFoundException;
import com.goservice.model.Address;
import com.goservice.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    /**
     * Adds an address to the database
     *
     * @param address Address object without addressId for database entry
     * @return returns the added to the address in database
     */
    @Override
    public Address addRentalAddress(Address address) {
        return addressRepository.save(address);
    }

    /**
     * Updates an existing address in the database
     *
     * @param address Address object with addressId update
     * @return returns the updated address from the database
     */
    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    /**
     * Deletes an address in the database based on the address id provided
     *
     * @param addressId Address id from the database
     */
    @Override
    public void deleteAddress(int addressId) {
        addressRepository.deleteById(addressId);
    }

    /**
     * Finds and returns a single Address object from the database based on the address id provided
     *
     * @param addressId Address id to find the address in the database
     * @return Returns the address found in the database
     * @throws AddressNotFoundException If the address could not be found in the database
     */
    @Override
    public Address getAddressById(int addressId) throws AddressNotFoundException {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException("No address found with the id of " + addressId));
    }

    /**
     * Find and returns addresses based on the locality name provided
     *
     * @param locality Locality name in the address
     * @return Returns a list of address found in the database
     * @throws AddressNotFoundException If no address is found in the database based on the provided info
     */
    @Override
    public List<Address> getByLocality(String locality) throws AddressNotFoundException {
        List<Address> addresses = new ArrayList<>();
        addresses = addressRepository.findByLocality(locality);

        if (addresses.isEmpty()) {
            throw new AddressNotFoundException("No address found in the locality of " + locality);
        }

        return addresses;
    }

    @Override
    public List<Address> getByState(String state) throws AddressNotFoundException {
        List<Address> addresses = new ArrayList<>();
        addresses = addressRepository.findByState(state);

        if (addresses.isEmpty()) {
            throw new AddressNotFoundException("No address found in the state of " + state);
        }

        return addresses;
    }

    @Override
    public List<Address> getByCity(String city) throws AddressNotFoundException {
        List<Address> addresses = new ArrayList<>();
        addresses = addressRepository.findByCity(city);

        if (addresses.isEmpty()) {
            throw new AddressNotFoundException("No address found in the city of " + city);
        }

        return addresses;
    }

    @Override
    public List<Address> getByZipcode(int zipcode) throws AddressNotFoundException {
        List<Address> addresses = new ArrayList<>();
        addresses = addressRepository.findByZipcode(zipcode);

        if (addresses.isEmpty()) {
            throw new AddressNotFoundException("No address found for the zipcode of " + zipcode);
        }

        return addresses;
    }
}
