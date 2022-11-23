package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.dto.request.PropertyDtoReq;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;

import java.util.List;

public interface PropertyService {
    List<PropertyDtoRes> findAll();

    PropertyDtoRes findById(long id);

    void deleteById(long id);

    Property save(PropertyDtoRes property);

    void update(long id, PropertyDtoRes property);

    void addProperty(AwesomeUserDetails user, PropertyDtoReq property);
}
