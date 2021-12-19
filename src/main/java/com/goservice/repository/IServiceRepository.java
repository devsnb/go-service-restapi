package com.goservice.repository;

import com.goservice.model.ServiceType;
import com.goservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findByName(ServiceType type);
}
