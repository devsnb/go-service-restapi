package com.goservice.repository;

import com.goservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByLocality(String locality);
    List<Address> findByState(String state);
    List<Address> findByCity(String city);
    List<Address> findByZipcode(int zipcode);
}
