package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.dto.PropertyDto;
import com.waa.property_management_portal.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PropertyDto> getAllProperty(){
        return propertyService.getAllProperty();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PropertyDto getPropertyById(@PathVariable("id") Long id){
        return propertyService.getPropertyById(id);

    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProperty(@RequestBody PropertyDto propertyDto){
        propertyService.addProperty(propertyDto);
    }
    //    @PutMapping("/{id}")
//
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long propertyId){
        propertyService.deleteById(propertyId);
    }
}
