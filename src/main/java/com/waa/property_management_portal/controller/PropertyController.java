package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.dto.request.PropertyDtoReq;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.service.PropertyService;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/")
    public List<PropertyDtoRes> getProperties() {
        return propertyService.findAll();
    }

    @PostMapping("/")
    public void addProperty(@AuthenticationPrincipal AwesomeUserDetails user, @RequestBody PropertyDtoReq property) {
        propertyService.addProperty(user, property);
    }

    @PutMapping("/{id}/{status}")
    public void udpateStatus(@PathVariable long id, @PathVariable PropertyStatus status) {
        propertyService.updateStaus(id, status);
    }
}
