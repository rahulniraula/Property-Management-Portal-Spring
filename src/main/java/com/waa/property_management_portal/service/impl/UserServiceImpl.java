package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Favorite;
import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;
import com.waa.property_management_portal.repository.RoleRepository;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDtoResponse> findAll() {
        return userRepo.findAll().stream()
                .map(u -> modelMapper.map(u, UserDtoResponse.class))
                .collect(Collectors.toList());
    }

    public UserDtoResponse findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDtoResponse.class);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User save(UserDtoRequest u) {
        User user = modelMapper.map(u, User.class);
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.addRole(roleRepository.findByRole(u.getRole().name()));
        return userRepo.save(user);
    }

    @Override
    public void update(long id, UserDtoRequest user) {
        User userToUpdate = userRepo.findById(id);
        if (userToUpdate != null) {
            userToUpdate.setFirstname(user.getFirstName());
            userToUpdate.setLastname(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPhoneNumber(user.getPhoneNumber());
            userToUpdate.setPassword(user.getPassword());
        }
    }

    @Override
    public List<Property> findProperties(long id) {
        User user = userRepo.findById(id);
        return user.getProperties();
    }

    @Override
    public List<Favorite> findFavorites(long id) {
        User user = userRepo.findById(id);
        return user.getFavorites();
    }
}
