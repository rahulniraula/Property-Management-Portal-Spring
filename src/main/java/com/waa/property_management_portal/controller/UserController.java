package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDtoRequest> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDtoRequest getUserById(@PathVariable("id") Long id){
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

}
