package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepo extends JpaRepository<PropertyDetails, Long> {
    void updatePropertyDetails(PropertyDetails propertyDetails, long id);
}
