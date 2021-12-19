package com.goservice.service;

import com.goservice.exceptions.ServiceCenterNotFoundException;
import com.goservice.model.Category;
import com.goservice.model.ServiceCenter;
import com.goservice.model.ServiceType;
import com.goservice.repository.IServiceCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCenterServiceImpl implements IServiceCenterService {

    @Autowired
    private IServiceCenterRepository serviceCenterRepository;

    @Override
    public ServiceCenter addServiceCenter(ServiceCenter serviceCenter) {
        return serviceCenterRepository.save(serviceCenter);
    }

    @Override
    public ServiceCenter updateServiceCenter(ServiceCenter serviceCenter) {
        return serviceCenterRepository.save(serviceCenter);
    }

    @Override
    public void deleteServiceCenter(int serviceCenterId) {
        serviceCenterRepository.deleteById(serviceCenterId);
    }

    @Override
    public ServiceCenter getServiceCenterById(int serviceCenterId) throws ServiceCenterNotFoundException {
        return serviceCenterRepository.findById(serviceCenterId)
                .orElseThrow(() -> new ServiceCenterNotFoundException("No service center wound with the id of " + serviceCenterId));
    }

    @Override
    public List<ServiceCenter> getAll() {
        return serviceCenterRepository.findAll();
    }

    @Override
    public List<ServiceCenter> getByName(String name) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByName(name);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found with the name of " + name);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByMinimumRating(double rating) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByRatingGreaterThan(rating);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found minimum rating of " + rating);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByAvgDuration(String duration) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByAvgDuration(duration);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found with duration of " + duration);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByLocality(String locality) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByLocality(locality);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found in the locality of " + locality);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByCity(String city) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByCity(city);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found in the city of " + city);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByState(String state) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByState(state);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found in the state of " + state);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByZipcode(int zipcode) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByZipcode(zipcode);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found in the zipcode of " + zipcode);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByVehicleCategory(Category category) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByVehicleCategory(category);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found for " + category + " vehicle");
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByVehicleManufacturer(String manufacturer) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByVehicleManufacturer(manufacturer);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found for the manufacturer " + manufacturer);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByVehicleModel(String model) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByVehicleModel(model);

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found for the model of " + model);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByServiceName(String name) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByServiceName(ServiceType.valueOf(name.toUpperCase()));

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found with the service of " + name);
        }

        return serviceCenters;
    }

    @Override
    public List<ServiceCenter> getByCityCategoryModelService(String city, String category, String model, String service) throws ServiceCenterNotFoundException {
        List<ServiceCenter> serviceCenters = new ArrayList<>();

        serviceCenters = serviceCenterRepository.findByCityCategoryModelService(city, Category.valueOf(category.toUpperCase()), model, ServiceType.valueOf(service.toUpperCase()));

        if (serviceCenters.isEmpty()) {
            throw new ServiceCenterNotFoundException("No service center found with your requirements");
        }

        return serviceCenters;
    }
}
