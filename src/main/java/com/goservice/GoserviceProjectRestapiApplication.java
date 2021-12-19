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
//        address.setZipcode(700078);
//        address.setState("West Bengal");
//        address.setCity("Kolkata");
//        address.setLocality("SamarPally");
//
//        Vehicle vehicle1 = new Vehicle();
//        vehicle1.setManufacturer("FORD");
//        vehicle1.setModel("A54F");
//        vehicle1.setCategory(Category.FOUR_WHEELER);
//        Vehicle savedVehicle = vehicleService.addVehicle(vehicle1);
//
//        Vehicle vehicle2 = new Vehicle();
//        vehicle2.setManufacturer("AUDI");
//        vehicle2.setModel("F35AF");
//        vehicle2.setCategory(Category.FOUR_WHEELER);
//        Vehicle savedVehicle2 = vehicleService.addVehicle(vehicle2);
//
//        Set<Vehicle> vehicles = new HashSet<>(Arrays.asList(savedVehicle, savedVehicle2));
//
//        ServiceCenter serviceCenter = new ServiceCenter();
//        serviceCenter.setName("CAR DETAILING");
//        serviceCenter.setAddress(address);
//        serviceCenter.setRating(4.6);
//        serviceCenter.setAvgDuration("5Hrs");
//        serviceCenter.setVehicles(vehicles);
//        ServiceCenter savedCenter = serviceCenterService.addServiceCenter(serviceCenter);


//        Service type = new Service();
//        type.setName(ServiceType.DENT_PAINT);
//        type.setServiceCenters(savedCenter);
//        serviceService.addService(type);


    }
}
