package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.dto.PropertyDto;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<PropertyDto> getAllProperty() {
        List<Property> properties = propertyRepo.findAll();
        return properties.stream()
                .map(u -> modelMapper.map(u, PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDto getPropertyById(Long id) {
        return modelMapper.map(propertyRepo.findById(id),PropertyDto.class);
    }

    @Override
    public void addProperty(PropertyDto propertyDto) {
        Property property = modelMapper.map(propertyDto, Property.class);
        propertyRepo.save(property);
    }

    @Override
    public void deleteById(long propertyId) {
        propertyRepo.deleteById(propertyId);
    }
}
