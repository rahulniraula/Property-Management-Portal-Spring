package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PropertyDetailsController {
    @Autowired
    PropertyDetailsService propertyDetailsService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PropertyDetails> getAllPropertyDetails(){
        return propertyDetailsService.getAllPropertyDetails();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PropertyDetails> getPropertyDetailsById(@PathVariable("id") long id){
        return propertyDetailsService.getPropertyDetailsById(id);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPropertyDetails(@RequestBody PropertyDetails propertyDetails){
        propertyDetailsService.addPropertyDetails(propertyDetails);
    }
    @PutMapping("/{id}")
    public void updatePropertyDetails(@RequestBody PropertyDetails propertyDetails, @PathVariable long id){
        propertyDetailsService.updatePropertyDetails(propertyDetails, id);
    }
    @DeleteMapping("/{id}")
    public void deletePropertyDetailsById(@PathVariable("id") long id){
        propertyDetailsService.deletePropertyDetailsById(id);
    }
}
