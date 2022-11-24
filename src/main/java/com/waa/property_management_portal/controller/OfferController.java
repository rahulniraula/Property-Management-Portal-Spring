package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.dto.request.OfferDto;
import com.waa.property_management_portal.enums.OfferStatus;
import com.waa.property_management_portal.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("/")
    public List<OfferDto> getOffers(){
        return offerService.getAll();
    }

    @PutMapping("/{id}/{status}")
    public void updateOfferStatus(@PathVariable long id, @PathVariable OfferStatus status) {
        offerService.updateStatus(id, status);
    }
    @PostMapping("/")
    public OfferDto save(@Valid @RequestBody OfferDto offerDto){
        return offerService.createOffer(offerDto);
    }
}
