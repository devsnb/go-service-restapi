package com.goservice;

import com.goservice.model.*;
import com.goservice.service.IAddressService;
import com.goservice.service.IServiceCenterService;
import com.goservice.service.IServiceService;
import com.goservice.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class GoserviceProjectRestapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GoserviceProjectRestapiApplication.class, args);
    }

    @Autowired
    private IServiceCenterService serviceCenterService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private IServiceService serviceService;

    @Override
    public void run(String... args) throws Exception {

//        Address address = new Address();
//        address.setZipcode(500081);
//        address.setState("Telengana");
//        address.setCity("Hyderabad");
//        address.setLocality("Madhapur");
//
//        Vehicle vehicle1 = new Vehicle();
//        vehicle1.setManufacturer("AUDI");
//        vehicle1.setModel("F368");
//        vehicle1.setCategory(Category.FOUR_WHEELER);
//        Vehicle savedVehicle = vehicleService.addVehicle(vehicle1);
//
//        Vehicle vehicle2 = new Vehicle();
//        vehicle2.setManufacturer("LAND ROVER");
//        vehicle2.setModel("SUV H65");
//        vehicle2.setCategory(Category.FOUR_WHEELER);
//        Vehicle savedVehicle2 = vehicleService.addVehicle(vehicle2);
//
//        Set<Vehicle> vehicles = new HashSet<>(Arrays.asList(savedVehicle, savedVehicle2));
//
//        ServiceCenter serviceCenter = new ServiceCenter();
//        serviceCenter.setName("EASY DETAIL");
//        serviceCenter.setAddress(address);
//        serviceCenter.setRating(4.5);
//        serviceCenter.setAvgDuration("6Hrs");
//        serviceCenter.setVehicles(vehicles);
//        ServiceCenter savedCenter = serviceCenterService.addServiceCenter(serviceCenter);
//
//        Service service = new Service();
//        service.setName(ServiceType.DETAILING);
//        service.setServiceCenters(savedCenter);
//        serviceService.addService(service);

    }
}
