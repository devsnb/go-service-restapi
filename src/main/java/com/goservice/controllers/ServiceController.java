package com.goservice.controllers;

import com.goservice.model.Service;
import com.goservice.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service-api")
public class ServiceController {

    @Autowired
    private IServiceService serviceService;

    /**
     * Add a service to the database
     *
     * @param service
     * @return returns the saved service from the database
     */
    @PostMapping("/services")
    ResponseEntity<Service> addService(@RequestBody Service service) {
        Service savedService = serviceService.addService(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedService);
    }

    /**
     * Updates a service in the database
     *
     * @param service
     * @return returns the updated service from the database
     */
    @PutMapping("/services")
    ResponseEntity<Service> updateService(@RequestBody Service service) {
        Service updatedService = serviceService.updateService(service);
        return ResponseEntity.ok().body(updatedService);
    }

    /**
     * Delete a service from the database
     *
     * @param serviceId
     */
    @DeleteMapping("/services/{serviceId}")
    ResponseEntity<Void> deleteService(@PathVariable("serviceId") int serviceId) {
        serviceService.deleteService(serviceId);
        return ResponseEntity.ok().build();
    }

    /**
     * Find all services from the database
     *
     * @return returns all the services from the database
     */
    @GetMapping("/services")
    ResponseEntity<List<Service>> getAll() {
        List<Service> services = serviceService.getAll();
        return ResponseEntity.ok().body(services);
    }

    /**
     * Find service by a service if
     *
     * @param serviceId
     * @return returns the found service
     */
    @GetMapping("/services/{serviceId}")
    ResponseEntity<Service> getServiceById(@PathVariable("serviceId") int serviceId) {
        Service service = serviceService.getServiceById(serviceId);
        return ResponseEntity.ok().body(service);
    }

    /**
     * Finds a service based on the name
     *
     * @param service
     * @return returns the service if it matches the name
     */
    @GetMapping("/services/name/{name}")
    ResponseEntity<List<Service>> getByServiceName(@PathVariable("name") String service) {
        List<Service> services = serviceService.getByServiceName(service);
        return ResponseEntity.ok().body(services);
    }
}
