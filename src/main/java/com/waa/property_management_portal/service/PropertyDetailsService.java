package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.PropertyDetails;

import java.util.List;
import java.util.Optional;

public interface PropertyDetailsService {
    List<PropertyDetails> getAllPropertyDetails();

    Optional<PropertyDetails> getPropertyDetailsById(long id);

    void addPropertyDetails(PropertyDetails propertyDetails);

    void updatePropertyDetails(PropertyDetails propertyDetails, long id);

    void deletePropertyDetailsById(long id);
}
