package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.enums.PropertyType;
import com.waa.property_management_portal.enums.UserRole;
import com.waa.property_management_portal.enums.UserStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/configs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UtilController {

    @GetMapping("/property-type")
    @ResponseStatus(HttpStatus.OK)
    public List<PropertyType> getAllEnumPropertyType(){
       return Arrays.asList(PropertyType.values());
    }

    @GetMapping("/property-status")
    @ResponseStatus(HttpStatus.OK)
    public List<PropertyStatus> getAllEnumPropertyStatus(){
        return Arrays.asList(PropertyStatus.values());
    }

    @GetMapping("/user-role")
    @ResponseStatus(HttpStatus.OK)
    public List<UserRole> getAllEnumUserRole(){
        return Arrays.asList(UserRole.values());
    }

    @GetMapping("/user-status")
    @ResponseStatus(HttpStatus.OK)
    public List<UserStatus> getAllEnumUserStatus(){
        return Arrays.asList(UserStatus.values());
    }
}
