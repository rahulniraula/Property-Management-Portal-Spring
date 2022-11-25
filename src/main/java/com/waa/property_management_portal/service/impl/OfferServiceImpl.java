package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Offer;
import com.waa.property_management_portal.entity.dto.request.OfferDtoRequest;
import com.waa.property_management_portal.enums.OfferStatus;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.repository.OfferRepo;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepo offerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PropertyRepo propertyRepo;
    @Override
    public OfferDtoRequest createOffer(OfferDtoRequest offerDto) {
        Offer offer=modelMapper.map(offerDto,Offer.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email=((AwesomeUserDetails)auth.getPrincipal()).getUsername();
        offer.setUser(userRepo.findByEmail(email));
        offer.setProperty(propertyRepo.findById(offerDto.getPropertyId()));
        offer.setOfferDate(LocalDateTime.now());
        offer.setStatus(OfferStatus.OFFERED);
        if(!offer.getProperty().getPropertyStatus().equals(PropertyStatus.CONTINGENT)){
            offer.getProperty().setPropertyStatus(PropertyStatus.PENDING);
        }
        Offer o = offerRepo.save(offer);
        return modelMapper.map(o, OfferDtoRequest.class);
    }

    @Override
    public List<OfferDtoRequest> getAll() {
        return offerRepo.findAll().stream().map(offer -> modelMapper.map(offer, OfferDtoRequest.class)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(long id, OfferStatus status) {
        Offer offer = offerRepo.findById(id);
        offer.setStatus(status);
        if(status.equals(OfferStatus.ACCEPTED)){
            offer.getProperty().setPropertyStatus(PropertyStatus.CONTINGENT);
        }
        offerRepo.save(offer);
    }


}
