package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.dto.request.PropertyDto;

import java.util.List;

public interface PropertyService {
    List<PropertyDto> findAll();

    PropertyDto findById(long id);

    void deleteById(long id);

    Property save(PropertyDto property);

    void update(long id, PropertyDto property);
}
