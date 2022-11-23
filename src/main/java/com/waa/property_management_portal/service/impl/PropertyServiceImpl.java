package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.PropertyDtoReq;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepo propertyRepo;

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    public PropertyServiceImpl(PropertyRepo propertyRepo, UserRepo userRepo, ModelMapper modelMapper) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PropertyDtoRes> findAll() {
        return propertyRepo.findAll().stream()
                .map(p -> modelMapper.map(p, PropertyDtoRes.class))
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDtoRes findById(long id) {
        return modelMapper.map(propertyRepo.findById(id), PropertyDtoRes.class);
    }

    @Override
    public void deleteById(long id) {
        propertyRepo.deleteById(id);
    }

    @Override
    public Property save(PropertyDtoRes p) {
        Property property = modelMapper.map(p, Property.class);
        return propertyRepo.save(property);
    }

    @Override
    public void update(long id, PropertyDtoRes property) {
        //TODO: Implement
    }

    @Override
    public void addProperty(AwesomeUserDetails user, PropertyDtoReq p) {
        User u = userRepo.findByEmail(user.getUsername());
        Property property = modelMapper.map(p, Property.class);
        property.setOwner(u);
        propertyRepo.save(property);
    }

    @Override
    public void updateStatus(long id, PropertyStatus status) {
        Property property = propertyRepo.findById(id);
        property.setPropertyStatus(status);
        propertyRepo.save(property);
    }
}
