package com.goservice.service;

import com.goservice.exceptions.ServiceCenterNotFoundException;
import com.goservice.model.Category;
import com.goservice.model.ServiceCenter;

import java.util.List;

public interface IServiceCenterService {
    ServiceCenter addServiceCenter(ServiceCenter serviceCenter);
    ServiceCenter updateServiceCenter(ServiceCenter serviceCenter);
    void deleteServiceCenter(int serviceCenterId);
    ServiceCenter getServiceCenterById(int serviceCenterId) throws ServiceCenterNotFoundException;

    List<ServiceCenter> getAll();
    List<ServiceCenter> getByName(String name) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByMinimumRating(double rating) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByAvgDuration(String duration) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByLocality(String locality) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByCity(String city) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByState(String state) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByZipcode(int zipcode) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByVehicleCategory(Category category) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByVehicleManufacturer(String manufacturer) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByVehicleModel(String model) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByServiceName(String name) throws ServiceCenterNotFoundException;
    List<ServiceCenter> getByCityCategoryModelService(String city, String category, String model, String service) throws ServiceCenterNotFoundException;

}
