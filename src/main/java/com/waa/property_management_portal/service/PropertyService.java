package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    List<PropertyDto> getAllProperty();
    PropertyDto getPropertyById(Long id);

    void addProperty(PropertyDto propertyDto);

    void deleteById(long propertyId);


}
