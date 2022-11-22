package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.repository.PropertyDetailsRepo;
import com.waa.property_management_portal.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {
    @Autowired
    public PropertyDetailsRepo propertyDetailsRepo;
    @Override
    public List<PropertyDetails> getAllPropertyDetails() {
        return propertyDetailsRepo.findAll();
    }

    @Override
    public Optional<PropertyDetails> getPropertyDetailsById(long id) {
        return propertyDetailsRepo.findById(id);
    }

    @Override
    public void addPropertyDetails(PropertyDetails propertyDetails) {
        propertyDetailsRepo.save(propertyDetails);
    }

    @Override
    public void updatePropertyDetails(PropertyDetails propertyDetails, long id) {
        propertyDetailsRepo.updatePropertyDetails(propertyDetails, id);
    }

    @Override
    public void deletePropertyDetailsById(long id) {
        propertyDetailsRepo.deleteById(id);
    }
}
