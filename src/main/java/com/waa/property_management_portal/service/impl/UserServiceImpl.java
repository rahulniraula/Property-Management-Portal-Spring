package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.User;
<<<<<<< HEAD
import com.waa.property_management_portal.entity.dto.UserDto;
=======
import com.waa.property_management_portal.entity.dto.response.UserDto;
>>>>>>> af9427a643c26b3cab160e4d0c7b2f251023f621
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
<<<<<<< HEAD
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(u -> modelMapper.map(u, UserDto.class))
=======

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(p -> modelMapper.map(p, UserDto.class))
>>>>>>> af9427a643c26b3cab160e4d0c7b2f251023f621
                .collect(Collectors.toList());
    }

    @Override
<<<<<<< HEAD
    public UserDto getUserById(Long id) {
        return modelMapper.map(userRepo.findById(id),UserDto.class);
    }

    @Override
    public void addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }

    @Override
    public void deleteById(long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public void updateUser(User user, long id) {
        userRepo.updateUser(user, id);
    }
=======
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void save(UserDto u) {
        User user = modelMapper.map(u, User.class);
        userRepo.save(user);
    }
>>>>>>> af9427a643c26b3cab160e4d0c7b2f251023f621
}
