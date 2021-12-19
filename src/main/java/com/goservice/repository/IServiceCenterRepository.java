package com.goservice.repository;

import com.goservice.exceptions.ServiceCenterNotFoundException;
import com.goservice.model.Category;
import com.goservice.model.ServiceCenter;
import com.goservice.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceCenterRepository extends JpaRepository<ServiceCenter, Integer> {
    List<ServiceCenter> findByName(String name);
    List<ServiceCenter> findByRatingGreaterThan(double rating);
    List<ServiceCenter> findByAvgDuration(String avgDuration);

//    Custom Queries
    @Query("from ServiceCenter sc inner join sc.address a where a.locality=?1")
    List<ServiceCenter> findByLocality(String locality) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.address a where a.city=?1")
    List<ServiceCenter> findByCity(String city) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.address a where a.state=?1")
    List<ServiceCenter> findByState(String state) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.address a where a.zipcode=?1")
    List<ServiceCenter> findByZipcode(int zipcode) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.vehicles v where v.category=?1")
    List<ServiceCenter> findByVehicleCategory(Category category) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.vehicles v where v.manufacturer=?1")
    List<ServiceCenter> findByVehicleManufacturer(String manufacturer) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.vehicles v where v.model=?1")
    List<ServiceCenter> findByVehicleModel(String model) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.services s where s.name=?1")
    List<ServiceCenter> findByServiceName(ServiceType type) throws ServiceCenterNotFoundException;

    @Query("from ServiceCenter sc inner join sc.address a inner join sc.vehicles v inner join sc.services sr where a.city=?1 and v.category=?2 and v.model=?3 and sr.name=?4")
    List<ServiceCenter> findByCityCategoryModelService(String city, Category category, String model, ServiceType service) throws ServiceCenterNotFoundException;
}
