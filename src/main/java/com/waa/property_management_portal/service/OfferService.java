package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.dto.request.OfferDtoRequest;
import com.waa.property_management_portal.enums.OfferStatus;

import java.util.List;

public interface OfferService {
    public OfferDtoRequest createOffer(OfferDtoRequest offerDto);
    public List<OfferDtoRequest> getAll();

    void updateStatus(long id, OfferStatus status);
}
