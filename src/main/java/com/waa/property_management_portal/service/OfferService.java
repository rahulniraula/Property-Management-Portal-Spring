package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.dto.request.OfferDto;

import java.util.List;

public interface OfferService {
    public OfferDto createOffer(OfferDto offerDto);
    public List<OfferDto> getAll();
}
