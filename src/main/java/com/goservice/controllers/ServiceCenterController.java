package com.goservice.controllers;

import com.goservice.model.Category;
import com.goservice.model.ServiceCenter;
import com.goservice.service.IServiceCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service-center-api")
public class ServiceCenterController {

    private Logger logger = LoggerFactory.getLogger(ServiceCenterController.class);

    @Autowired
    private IServiceCenterService serviceCenterService;

    /**
     * Adds a service center to the database
     *
     * @param serviceCenter
     * @return returns the added service center
     */
    @PostMapping("/service-center")
    ResponseEntity<ServiceCenter> addServiceCenter(@RequestBody ServiceCenter serviceCenter) {
        ServiceCenter savedServiceCenter = serviceCenterService.addServiceCenter(serviceCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServiceCenter);
    }

    /**
     * Updates a service center in the database
     *
     * @param serviceCenter
     * @return returns the updated service center
     */
    @PutMapping("/service-center")
    ResponseEntity<ServiceCenter> updateServiceCenter(@RequestBody ServiceCenter serviceCenter) {
        ServiceCenter updatedServiceCenter = serviceCenterService.updateServiceCenter(serviceCenter);
        return ResponseEntity.ok().body(updatedServiceCenter);
    }

    /**
     * Deletes a service center by id
     *
     * @param serviceCenterId
     */
    @DeleteMapping("/service-center/{centerId}")
    ResponseEntity<Void> deleteServiceCenter(@PathVariable("centerId") int serviceCenterId) {
        serviceCenterService.deleteServiceCenter(serviceCenterId);
        return ResponseEntity.ok().build();
    }

    /**
     * Finds service center by id
     *
     * @param serviceCenterId
     * @return returns the found service center
     */
    @GetMapping("/service-center/{centerId}")
    ResponseEntity<ServiceCenter> getServiceCenterById(@PathVariable("centerId") int serviceCenterId) {
        ServiceCenter foundServiceCenter = serviceCenterService.getServiceCenterById(serviceCenterId);
        return ResponseEntity.ok().body(foundServiceCenter);
    }

    /**
     * Finds all service center from the database
     *
     * @return returns a list of service center
     */
    @GetMapping("/service-center")
    ResponseEntity<List<ServiceCenter>> getAll() {
        List<ServiceCenter> serviceCenters = serviceCenterService.getAll();
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center based on name
     *
     * @param name
     * @return returns found service center
     */
    @GetMapping("/service-center/name/{name}")
    ResponseEntity<List<ServiceCenter>> getByName(@PathVariable("name") String name) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByName(name);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center by rating
     *
     * @param rating
     * @return returns found service centers
     */
    @GetMapping("/service-center/rating/{rating}")
    ResponseEntity<List<ServiceCenter>> getByRating(@PathVariable("rating") double rating) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByMinimumRating(rating);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center by average servicing duration
     *
     * @param duration
     * @return returns found service centers
     */
    @GetMapping("/service-center/duration/{duration}")
    ResponseEntity<List<ServiceCenter>> getByAvgDuration(@PathVariable("duration") String duration) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByAvgDuration(duration);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center in a particular locality
     *
     * @param locality
     * @return returns found service centers
     */
    @GetMapping("/service-center/locality/{locality}")
    ResponseEntity<List<ServiceCenter>> getByLocality(@PathVariable("locality") String locality) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByLocality(locality);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center in a specific city
     *
     * @param city
     * @return returns found service centers
     */
    @GetMapping("/service-center/city/{city}")
    ResponseEntity<List<ServiceCenter>> getByCity(@PathVariable("city") String city) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByCity(city);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center in a specific state
     *
     * @param state
     * @return returns found service centers
     */
    @GetMapping("/service-center/state/{state}")
    ResponseEntity<List<ServiceCenter>> getByState(@PathVariable("state") String state) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByState(state);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center in a particular zipcode
     *
     * @param zipcode
     * @return returns found service centers
     */
    @GetMapping("/service-center/zipcode/{zipcode}")
    ResponseEntity<List<ServiceCenter>> getByZipcode(@PathVariable("zipcode") int zipcode) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByZipcode(zipcode);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center based on a vehicle category
     *
     * @param category
     * @return returns found service centers
     */
    @GetMapping("/service-center/vehicle/category/{category}")
    ResponseEntity<List<ServiceCenter>> getByVehicleCategory(@PathVariable("category") Category category) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByVehicleCategory(category);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center based on a vehicle manufacturer
     *
     * @param manufacturer
     * @return returns found service centers
     */
    @GetMapping("service-center/vehicle/manufacturer/{name}")
    ResponseEntity<List<ServiceCenter>> getByVehicleManufacturer(@PathVariable("name") String manufacturer) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByVehicleManufacturer(manufacturer);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center based on a model number of the vehicle
     *
     * @param model
     * @return returns found service centers
     */
    @GetMapping("/service-center/vehicle/model/{model}")
    ResponseEntity<List<ServiceCenter>> getByVehicleModel(@PathVariable("model") String model) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByVehicleModel(model);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds vehicle based on a specific service name
     *
     * @param name
     * @return returns found service centers
     */
    @GetMapping("/service-center/service/type/{name}")
    ResponseEntity<List<ServiceCenter>> getByServiceName(@PathVariable("name") String name) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByServiceName(name);
        return ResponseEntity.ok().body(serviceCenters);
    }

    /**
     * Finds service center based on city, category, model and required service
     *
     * @param city
     * @param category
     * @param model
     * @param service
     * @return returns found service centers
     */
    @GetMapping("/service-center/search")
    ResponseEntity<List<ServiceCenter>> getByCityCategoryModelService(@RequestParam("city") String city,
                                                                      @RequestParam("category") String category,
                                                                      @RequestParam("model") String model,
                                                                      @RequestParam("service") String service) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getByCityCategoryModelService(city, category, model, service);
        return ResponseEntity.ok().body(serviceCenters);
    }
}
