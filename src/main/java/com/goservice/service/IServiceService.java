package com.goservice.service;

import com.goservice.exceptions.ServiceNotFoundException;
import com.goservice.model.Service;

import java.util.List;

public interface IServiceService {
    Service addService(Service service);
    Service updateService(Service service);
    void deleteService(int serviceId);
    Service getServiceById(int serviceId) throws ServiceNotFoundException;
    List<Service> getAll();
    List<Service> getByServiceName(String service) throws ServiceNotFoundException;

}
