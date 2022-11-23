package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {
    List<Property> findAll();

    Property findById(long id);
}
