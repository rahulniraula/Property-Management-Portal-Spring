package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Favorite;
import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.FavoriteDto;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;
import com.waa.property_management_portal.enums.UserRole;
import com.waa.property_management_portal.enums.UserStatus;
import com.waa.property_management_portal.repository.FavoriteRepo;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.repository.RoleRepository;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FavoriteRepo favRepo;
    @Autowired
    private PropertyRepo propertyRepo;
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
        if (role.equals(UserRole.ADMIN)) {
            throw new RuntimeException("You can not register as an admin.");
        }
        User user = modelMapper.map(u, User.class);
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.addRole(roleRepository.findByRole(role));
        UserStatus status = role.equals(UserRole.OWNER) ? UserStatus.INACTIVE : UserStatus.ACTIVE;
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
    public List<Favorite> findFavorites(long id) {
        User user = userRepo.findById(id);
        return user.getFavorites();
    }

    @Override
    public void addFavorite(long id, FavoriteDto fav) {
        User user = userRepo.findById(id);
        Favorite favorite = modelMapper.map(fav, Favorite.class);
        favorite.setUser(user);
        favRepo.save(favorite);
    }

    @Override
    public void addPropertyToFavorite(long id, long favId, long propId) {
        User user = userRepo.findById(id);
        Property property = propertyRepo.findById(propId);
        Favorite favorite = favRepo.findById(favId);
        favorite.setUser(user);
        favorite.getProperties().add(property);
        favRepo.save(favorite);
    }
}
