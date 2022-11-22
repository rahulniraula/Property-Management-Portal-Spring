package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
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
    public List<UserDtoRequest> findAll() {
        return userRepo.findAll().stream()
                .map(p -> modelMapper.map(p, UserDtoRequest.class))
                .collect(Collectors.toList());
    }

    public UserDtoRequest findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDtoRequest.class);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User save(UserDtoRequest u) {
        User user = modelMapper.map(u, User.class);

        return userRepo.save(user);
    }

    @Override
    public void update(long id, UserDtoRequest user) {
        User userToUpdate = userRepo.findById(id);
        if (userToUpdate != null) {
            userToUpdate.setFirstname(user.getFirstname());
            userToUpdate.setLastname(user.getLastname());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPhoneNumber(user.getPhoneNumber());
            userToUpdate.setPassword(user.getPassword());
        }
    }
}
