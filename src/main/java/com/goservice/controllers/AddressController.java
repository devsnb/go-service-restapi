package com.goservice.controllers;

import com.goservice.model.Address;
import com.goservice.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address-api")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/addresses")
    ResponseEntity<Address> addRentalAddress(@RequestBody Address address) {
        Address createdAddress = addressService.addRentalAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @PutMapping("/addresses")
    ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(address);
        return ResponseEntity.ok().body(updatedAddress);
    }

    @DeleteMapping("/addresses/{addressId}")
    ResponseEntity<Void> deleteAddress(@PathVariable("addressId") int addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/addresses/{addressId}")
    ResponseEntity<Address> getAddressById(@PathVariable("addressId") int addressId) {
        Address address = addressService.getAddressById(addressId);
        return ResponseEntity.ok().body(address);
    }

    @GetMapping("/addresses/locality/{locality}")
    ResponseEntity<List<Address>> getByLocality(@PathVariable("locality") String locality) {
        List<Address> addresses = addressService.getByLocality(locality);
        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping("/addresses/state/{state}")
    ResponseEntity<List<Address>> getByState(@PathVariable("state") String state) {
        List<Address> addresses = addressService.getByState(state);
        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping("/addresses/city/{city}")
    ResponseEntity<List<Address>> getByCity(@PathVariable("city") String city) {
        List<Address> addresses = addressService.getByCity(city);
        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping("/addresses/zipcode/{zipcode}")
    ResponseEntity<List<Address>> getByZipcode(@PathVariable("zipcode") int zipcode) {
        List<Address> addresses = addressService.getByZipcode(zipcode);
        return ResponseEntity.ok().body(addresses);
    }
}
