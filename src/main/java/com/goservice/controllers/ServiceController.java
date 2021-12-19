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

    @PostMapping("/services")
    ResponseEntity<Service> addService(@RequestBody Service service) {
        Service savedService = serviceService.addService(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedService);
    }

    @PutMapping("/services")
    ResponseEntity<Service> updateService(@RequestBody Service service) {
        Service updatedService = serviceService.updateService(service);
        return ResponseEntity.ok().body(updatedService);
    }

    @DeleteMapping("/services/{serviceId}")
    ResponseEntity<Void> deleteService(@PathVariable("serviceId") int serviceId) {
        serviceService.deleteService(serviceId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/services")
    ResponseEntity<List<Service>> getAll() {
        List<Service> services = serviceService.getAll();
        return ResponseEntity.ok().body(services);
    }

    @GetMapping("/services/{serviceId}")
    ResponseEntity<Service> getServiceById(@PathVariable("serviceId") int serviceId) {
        Service service = serviceService.getServiceById(serviceId);
        return ResponseEntity.ok().body(service);
    }

    @GetMapping("/services/name/{name}")
    ResponseEntity<List<Service>> getByServiceName(@PathVariable("name") String service) {
        List<Service> services = serviceService.getByServiceName(service);
        return ResponseEntity.ok().body(services);
    }
}
