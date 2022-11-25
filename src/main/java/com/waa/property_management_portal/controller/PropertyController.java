package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.dto.request.OfferDtoRequest;
import com.waa.property_management_portal.entity.dto.request.PropertyDtoReq;
import com.waa.property_management_portal.entity.dto.response.OfferDtoResponse;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.model.PropertySearchCriteria;
import com.waa.property_management_portal.service.PropertyService;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/properties")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/")
    public List<PropertyDtoRes> getProperties(@RequestParam(required = false) Map<String,String> searchCriteria) {

        if (searchCriteria.size() > 0) {
            return propertyService.findAllWithFilters(searchCriteria);
        }
        return propertyService.findPropertiesForLoggedInUser();
    }

    @PostMapping("/")
    public void addProperty(@AuthenticationPrincipal AwesomeUserDetails user, @Valid @RequestBody PropertyDtoReq property) {
        propertyService.addProperty(user, property);
    }

    @PutMapping("/{id}/{status}")
    public void updateStatus(@PathVariable long id, @PathVariable PropertyStatus status) {
        propertyService.updateStatus(id, status);
    }
    @GetMapping("/{id}/offers")
    public List<OfferDtoResponse> getOffers(@PathVariable Long id){
        return propertyService.getOffers(id);
    }
    @PutMapping("/{id}/cancel-contingency")
    public void cancelContingency(@PathVariable Long id){
         propertyService.cancelContingency(id);
    }
}
