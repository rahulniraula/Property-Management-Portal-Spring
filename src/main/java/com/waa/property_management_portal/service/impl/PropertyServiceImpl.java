package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.dto.request.PropertyDto;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepo propertyRepo;

    private final ModelMapper modelMapper;

    public PropertyServiceImpl(PropertyRepo propertyRepo, ModelMapper modelMapper) {
        this.propertyRepo = propertyRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PropertyDto> findAll() {
        return propertyRepo.findAll().stream()
                .map(p -> modelMapper.map(p, PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDto findById(long id) {
        return modelMapper.map(propertyRepo.findById(id), PropertyDto.class);
    }

    @Override
    public void deleteById(long id) {
        propertyRepo.deleteById(id);
    }

    @Override
    public Property save(PropertyDto p) {
        Property property = modelMapper.map(p, Property.class);
        return propertyRepo.save(property);
    }

    @Override
    public void update(long id, PropertyDto property) {
        //TODO: Implement
    }
}
