/**
 * The Controller Class For Address
 *
 * @author Snehansghu Biswas
 */

package com.goservice.controllers;

import com.goservice.model.Address;
import com.goservice.service.IAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address-api")
public class AddressController {

    private final Logger logger = LoggerFactory.getLogger(ServiceCenterController.class);


    @Autowired
    private IAddressService addressService;

    /**
     * Adds an address to the database
     *
     * @param address Address object without addressId for database entry
     * @return returns the added to the address in database
     */
    @PostMapping("/addresses")
    ResponseEntity<Address> addAddress(@RequestBody Address address) {
        logger.debug("Inside Address Controller");
        logger.info("POST /address-api/addresses");
        logger.debug("Inside addAddress Method");
        Address createdAddress = addressService.addRentalAddress(address);
        logger.debug("addressService.addRentalAddress  Called");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    /**
     * Updates an existing address in the database
     *
     * @param address Address object with addressId update
     * @return returns the updated address from the database
     */
    @PutMapping("/addresses")
    ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        logger.debug("Inside Address Controller");
        logger.info("PUT /address-api/addresses");
        logger.debug("Inside updateAddress Method");
        Address updatedAddress = addressService.updateAddress(address);
        logger.debug("addressService.updateAddress Called");
        return ResponseEntity.ok().body(updatedAddress);
    }

    /**
     * Deletes an address in the database based on the address id provided
     *
     * @param addressId Address id from the database
     */
    @DeleteMapping("/addresses/{addressId}")
    ResponseEntity<Void> deleteAddress(@PathVariable("addressId") int addressId) {
        logger.debug("Inside Address Controller");
        logger.info("DELETE /address-api/addresses/{addressId}");
        logger.debug("Inside deleteAddress Method");
        addressService.deleteAddress(addressId);
        logger.debug("addressService.deleteAddress Called");
        return ResponseEntity.ok().build();
    }

    /**
     * Finds and returns a single Address object from the database based on the address id provided
     *
     * @param addressId Address id to find the address in the database
     * @return Returns the address found in the database
     */
    @GetMapping("/addresses/{addressId}")
    ResponseEntity<Address> getAddressById(@PathVariable("addressId") int addressId) {
        logger.debug("Inside Address Controller");
        logger.info("GET /address-api/addresses/{addressId}");
        logger.debug("Inside getAddressById");
        Address address = addressService.getAddressById(addressId);
        logger.debug("addressService.getAddressById Called");
        return ResponseEntity.ok().body(address);
    }

    /**
     * Find and returns addresses based on the locality name provided
     *
     * @param locality Locality name in the address
     * @return Returns a list of Address found in the database
     */
    @GetMapping("/addresses/locality/{locality}")
    ResponseEntity<List<Address>> getByLocality(@PathVariable("locality") String locality) {
        logger.debug("Inside Address Controller");
        logger.info("GET /addresses/locality/{locality}");
        logger.debug("Inside getByLocality Method");
        List<Address> addresses = addressService.getByLocality(locality);
        logger.debug("addressService.getByLocality Called");
        return ResponseEntity.ok().body(addresses);
    }

    /**
     * Finds and returns Addresses based on the state name provided
     *
     * @param state State name in the address
     * @return Returns a list of Address found in the database
     */
    @GetMapping("/addresses/state/{state}")
    ResponseEntity<List<Address>> getByState(@PathVariable("state") String state) {
        logger.debug("Inside Address Controller");
        logger.info("GET addresses/addresses/state/{state}");
        logger.debug("Inside getByState Method");
        List<Address> addresses = addressService.getByState(state);
        logger.debug("addressService.getByState Called");
        return ResponseEntity.ok().body(addresses);
    }

    /**
     * Finds and returns Addresses based on the city name provided
     *
     * @param city City name in the address
     * @return Returns a list of Address found in the database
     */
    @GetMapping("/addresses/city/{city}")
    ResponseEntity<List<Address>> getByCity(@PathVariable("city") String city) {
        logger.debug("Inside Address Controller");
        logger.info("GET addresses/addresses/city/{city}");
        logger.debug("Inside getByCity Method");
        List<Address> addresses = addressService.getByCity(city);
        logger.debug("addressService.getByCity Called");
        return ResponseEntity.ok().body(addresses);
    }

    /**
     * Finds and returns Addresses based on the zipcode provided
     *
     * @param zipcode Zipcode in the address
     * @return Returns a list of Address found in the database
     */
    @GetMapping("/addresses/zipcode/{zipcode}")
    ResponseEntity<List<Address>> getByZipcode(@PathVariable("zipcode") int zipcode) {
        logger.debug("Inside Address Controller");
        logger.info("GET addresses/addresses/zipcode/{zipcode}");
        logger.debug("Inside getByZipcode Method");
        List<Address> addresses = addressService.getByZipcode(zipcode);
        logger.debug("addressService.getByZipcode Called");
        return ResponseEntity.ok().body(addresses);
    }
}
