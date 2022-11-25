package com.waa.property_management_portal.controller.public_access;

import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.model.PropertySearchCriteria;
import com.waa.property_management_portal.service.EmailService;
import com.waa.property_management_portal.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/public/properties")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
public class MYPropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private EmailService emailService;
    @GetMapping("/")
    public List<PropertyDtoRes> getProperties(@RequestParam(required = false) Map<String,String> searchCriteria) {

        if (searchCriteria.size() > 0) {
            System.out.println("Entered");
            return propertyService.findAllWithFilters(searchCriteria);
        }
        return propertyService.findAll();
    }
    @GetMapping("/{id}")
    public PropertyDtoRes findOne(@PathVariable long id){
        return propertyService.findById(id);
    }

}
