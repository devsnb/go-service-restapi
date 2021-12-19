package com.goservice.repository;

import com.goservice.exceptions.VehicleNotFoundException;
import com.goservice.model.Category;
import com.goservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByCategory(Category category);
    List<Vehicle> findByModel(String model);
    List<Vehicle> findByManufacturer(String manufacturer);
}
