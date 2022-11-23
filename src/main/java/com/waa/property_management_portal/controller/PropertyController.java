package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.dto.request.PropertyDto;
import com.waa.property_management_portal.service.PropertyService;
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
    public List<PropertyDto> getProperties() {
        return propertyService.findAll();
    }
}
