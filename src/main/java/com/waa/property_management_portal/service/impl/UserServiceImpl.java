package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.PasswordDto;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.OfferDtoResponse;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;
import com.waa.property_management_portal.enums.UserRole;
import com.waa.property_management_portal.enums.UserStatus;
import com.waa.property_management_portal.repository.RoleRepository;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.UserService;
import com.waa.property_management_portal.util.Util;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
        String role = u.getRole().name();
        if (role.equals(UserRole.ADMIN.name())) {
            throw new RuntimeException("You can not register as an admin.");
        }
        User user = modelMapper.map(u, User.class);
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.addRole(roleRepository.findByRole(role));
        UserStatus status = role.equals(UserRole.OWNER.name()) ? UserStatus.INACTIVE : UserStatus.ACTIVE;
        user.setStatus(status);
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
    public List<PropertyDtoRes> findProperties(long id) {
        User user = userRepo.findById(id);
        List<Property> properties = user.getProperties();
        return properties.stream()
                .map(p -> modelMapper.map(p, PropertyDtoRes.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateStatus(long id, UserStatus status) {
        User user = userRepo.findById(id);
        user.setStatus(status);
        userRepo.save(user);

    }

    @Override
    public List<OfferDtoResponse> getOffers(AwesomeUserDetails u, long id) {
        User user = userRepo.findByEmail(u.getUsername());
        return user.getOffers()
                .stream()
                .map(offer -> modelMapper.map(offer,OfferDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void resetPassword(long id, PasswordDto p) {
        if (!Util.loggedInUserHasRole(UserRole.ADMIN.name())) {
            throw new RuntimeException("Only Admin can reset password!");
        }
        User user = userRepo.findById(id);
        user.setPassword(passwordEncoder.encode(p.getPassword()));
        userRepo.save(user);
    }
}
