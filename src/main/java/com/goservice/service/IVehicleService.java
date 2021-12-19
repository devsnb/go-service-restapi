package com.goservice.service;

import com.goservice.exceptions.VehicleNotFoundException;
import com.goservice.model.Category;
import com.goservice.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(int vehicleId);
    Vehicle getVehicleById(int vehicleId) throws VehicleNotFoundException;
    List<Vehicle> getAll();

    List<Vehicle> getByModel(String model) throws VehicleNotFoundException;
    List<Vehicle> getByManufacturer(String manufacturer) throws VehicleNotFoundException;
    List<Vehicle> getByCategory(String category) throws VehicleNotFoundException;
}
