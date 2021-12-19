package com.goservice.service;

import com.goservice.exceptions.VehicleNotFoundException;
import com.goservice.model.Category;
import com.goservice.model.Vehicle;
import com.goservice.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public Vehicle getVehicleById(int vehicleId) throws VehicleNotFoundException {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException("No vehicle found with the id of " + vehicleId));
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getByModel(String model) throws VehicleNotFoundException {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = vehicleRepository.findByModel(model);

        if(vehicles.isEmpty()) {
            throw new VehicleNotFoundException("No vehicle found with the model name of " + model);
        }

        return vehicles;
    }

    @Override
    public List<Vehicle> getByManufacturer(String manufacturer) throws VehicleNotFoundException {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = vehicleRepository.findByManufacturer(manufacturer);

        if(vehicles.isEmpty()) {
            throw new VehicleNotFoundException("No vehicle found with the manufacturer of " + manufacturer);
        }

        return vehicles;
    }

    @Override
    public List<Vehicle> getByCategory(String category) throws VehicleNotFoundException {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = vehicleRepository.findByCategory(Category.valueOf(category.toUpperCase()));

        if(vehicles.isEmpty()) {
            throw new VehicleNotFoundException("No vehicle found in the category of " + category);
        }

        return vehicles;
    }
}
