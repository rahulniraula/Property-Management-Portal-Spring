package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.dto.request.OfferDtoRequest;
import com.waa.property_management_portal.entity.dto.request.PropertyDtoReq;
import com.waa.property_management_portal.entity.dto.response.OfferDtoResponse;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.model.PropertySearchCriteria;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;

import java.util.List;
import java.util.Map;

public interface PropertyService {
    List<PropertyDtoRes> findAll();

    List<PropertyDtoRes> findAllWithFilters(Map<String,String> searchCriteria);

    PropertyDtoRes findById(long id);

    void deleteById(long id);

    Property save(PropertyDtoRes property);

    void update(long id, PropertyDtoRes property);

    void addProperty(AwesomeUserDetails user, PropertyDtoReq property);

    void updateStatus(long id, PropertyStatus status);
    public List<OfferDtoResponse> getOffers(long productId);
    public void cancelContingency(long id);

}
