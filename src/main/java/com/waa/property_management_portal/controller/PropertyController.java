package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PropertyController {

    private UserService userService;

    public PropertyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Property> getProperties(@PathVariable long userId) {
        return userService.findProperties(userId);
    }
}
