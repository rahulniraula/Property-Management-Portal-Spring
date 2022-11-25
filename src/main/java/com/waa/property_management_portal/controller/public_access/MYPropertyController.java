package com.waa.property_management_portal.controller.public_access;

import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.model.PropertySearchCriteria;
import com.waa.property_management_portal.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/public/properties")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
public class MYPropertyController {
    @Autowired
    private PropertyService propertyService;
    @GetMapping("/")
    public List<PropertyDtoRes> getProperties(@RequestBody(required = false) PropertySearchCriteria searchCriteria) {
        if (searchCriteria != null) {
            return propertyService.findAllWithFilters(searchCriteria);
        }
        return propertyService.findAll();
    }
    @GetMapping("/{id}")
    public PropertyDtoRes findOne(@PathVariable long id){
        return propertyService.findById(id);
    }

}
