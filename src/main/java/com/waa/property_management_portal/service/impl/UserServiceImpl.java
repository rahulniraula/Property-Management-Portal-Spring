package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.UserDto;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(p -> modelMapper.map(p, UserDto.class))
                .collect(Collectors.toList());
    }

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

    @Override
    public void update(long id, UserDto user) {
        //TODO:
    }
}
