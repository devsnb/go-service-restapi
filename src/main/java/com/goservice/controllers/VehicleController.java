package com.goservice.controllers;

import com.goservice.model.Vehicle;
import com.goservice.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle-api")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    /**
     * Adds a vehicle in the database
     *
     * @param vehicle
     * @return Returns a vehicle
     */
    @PostMapping("/vehicles")
    ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    /**
     * Updates a vehicle in the database
     *
     * @param vehicle
     * @return returns the updated vehicle in the database
     */
    @PutMapping("/vehicles")
    ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle);
        return ResponseEntity.ok().body(updatedVehicle);
    }

    /**
     * Delete a vehicle based on the vehicle id
     *
     * @param vehicleId
     */
    @DeleteMapping("/vehicles/{vehicleId}")
    ResponseEntity<Void> deleteVehicle(@PathVariable("vehicleId") int vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok().build();
    }

    /**
     * Finds a vehicle based on vehicleId
     *
     * @param vehicleId
     * @return returns the found vehicle
     */
    @GetMapping("/vehicles/{vehicleId}")
    ResponseEntity<Vehicle> getVehicleById(@PathVariable("vehicleId") int vehicleId) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok().body(vehicle);
    }

    /**
     * Finds all the vehicles in the database
     *
     * @return returns a list of vehicles
     */
    @GetMapping("/vehicles")
    ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = vehicleService.getAll();
        return ResponseEntity.ok().body(vehicles);
    }

    /**
     * Finds vehicle based on model number
     *
     * @param model
     * @return returns a lust of vehicles
     */
    @GetMapping("/vehicles/model/{model}")
    ResponseEntity<List<Vehicle>> getByModel(@PathVariable("model") String model) {
        List<Vehicle> vehicles = vehicleService.getByModel(model);
        return ResponseEntity.ok().body(vehicles);
    }

    /**
     * Finds vehicle based on manufacturer name
     *
     * @param manufacturer
     * @return returns vehicle list
     */
    @GetMapping("/vehicles/manufacturer/{name}")
    ResponseEntity<List<Vehicle>> getByManufacturer(@PathVariable("name") String manufacturer) {
        List<Vehicle> vehicles = vehicleService.getByManufacturer(manufacturer);
        return ResponseEntity.ok().body(vehicles);
    }

    /**
     * Finds vehicle based on a category
     *
     * @param category
     * @return returns a vehicle list
     */
    @GetMapping("/vehicles/category/{category}")
    ResponseEntity<List<Vehicle>> getByCategory(@PathVariable("category") String category) {
        List<Vehicle> vehicles = vehicleService.getByCategory(category);
        return ResponseEntity.ok().body(vehicles);
    }
}
