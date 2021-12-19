package com.goservice.service;

import com.goservice.exceptions.ServiceNotFoundException;
import com.goservice.model.ServiceType;
import com.goservice.model.Service;
import com.goservice.repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Service addService(Service type) {
        return serviceRepository.save(type);
    }

    @Override
    public Service updateService(Service type) {
        return serviceRepository.save(type);
    }

    @Override
    public void deleteService(int typeId) {
        serviceRepository.deleteById(typeId);
    }

    @Override
    public Service getServiceById(int typeId) throws ServiceNotFoundException {
        return serviceRepository.findById(typeId)
                .orElseThrow(() -> new ServiceNotFoundException("No service type found with the id of " + typeId));
    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<Service> getByServiceName(String service) throws ServiceNotFoundException {
        return serviceRepository.findByName(ServiceType.valueOf(service.toUpperCase()));
    }
}
