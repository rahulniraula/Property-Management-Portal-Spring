package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.OfferDtoResponse;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;
import com.waa.property_management_portal.enums.UserStatus;
import com.waa.property_management_portal.service.UserService;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDtoResponse> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDtoResponse getUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDtoRequest userDtoRequest){
        userService.save(userDtoRequest);
    }
    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserDtoRequest user, @PathVariable("id") long id){
        userService.update(id, user);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long userId){
        userService.deleteById(userId);
    }

    @GetMapping("/{id}/properties")
    public List<PropertyDtoRes> getProperties(@PathVariable long id) {
        return userService.findProperties(id);
    }

    @PutMapping("/{id}/{status}")
    public void updateStatus(@PathVariable long id, @PathVariable UserStatus status) {
        userService.updateStatus(id, status);
    }
    @GetMapping("/{id}/offers")
    public List<OfferDtoResponse> getOffers(@AuthenticationPrincipal AwesomeUserDetails user,@PathVariable long id){
        return userService.getOffers(user,id);
    }

}
