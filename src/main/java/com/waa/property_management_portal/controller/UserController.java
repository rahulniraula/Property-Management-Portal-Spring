package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.UserDto;
import com.waa.property_management_portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);

    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
    }
    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id") long id){
        userService.updateUser(user,id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long userId){
        userService.deleteById(userId);
    }

}
