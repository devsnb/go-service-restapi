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

    @PostMapping("/vehicles")
    ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @PutMapping("/vehicles")
    ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle);
        return ResponseEntity.ok().body(updatedVehicle);
    }

    @DeleteMapping("/vehicles/{vehicleId}")
    ResponseEntity<Void> deleteVehicle(@PathVariable("vehicleId") int vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/vehicles/{vehicleId}")
    ResponseEntity<Vehicle> getVehicleById(@PathVariable("vehicleId") int vehicleId) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok().body(vehicle);
    }

    @GetMapping("/vehicles")
    ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = vehicleService.getAll();
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/model/{model}")
    ResponseEntity<List<Vehicle>> getByModel(@PathVariable("model") String model) {
        List<Vehicle> vehicles = vehicleService.getByModel(model);
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/manufacturer/{name}")
    ResponseEntity<List<Vehicle>> getByManufacturer(@PathVariable("name") String manufacturer) {
        List<Vehicle> vehicles = vehicleService.getByManufacturer(manufacturer);
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/category/{category}")
    ResponseEntity<List<Vehicle>> getByCategory(@PathVariable("category") String category) {
        List<Vehicle> vehicles = vehicleService.getByCategory(category);
        return ResponseEntity.ok().body(vehicles);
    }
}
