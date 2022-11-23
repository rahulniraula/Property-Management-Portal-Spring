package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Address;
import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.PropertyDtoReq;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.model.PropertySearchCriteria;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepo propertyRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public PropertyServiceImpl(PropertyRepo propertyRepo, UserRepo userRepo,
                               ModelMapper modelMapper, EntityManager entityManager) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.entityManager = entityManager;
        this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
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
    public List<PropertyDtoRes> findAllWithFilters(PropertySearchCriteria searchCriteria) {
        CriteriaQuery<Property> query = criteriaBuilder.createQuery(Property.class);
        Root<Property> root = query.from(Property.class);
        Predicate predicate = getPredicate(searchCriteria, root);
        query.where(predicate);
        TypedQuery<Property> typedQuery = entityManager.createQuery(query);
        List<Property> results = typedQuery.getResultList();
        return results.stream()
                .map(p -> modelMapper.map(p, PropertyDtoRes.class))
                .collect(Collectors.toList());
    }

    private Predicate getPredicate(PropertySearchCriteria searchCriteria, Root<Property> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (!searchCriteria.getTitle().isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + searchCriteria.getTitle() + "%"));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
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
//        property.setAddress(modelMapper.map(p.getAddress(), Address.class));
        property.setDetails(modelMapper.map(p, PropertyDetails.class));
        propertyRepo.save(property);
    }

    @Override
    public void updateStatus(long id, PropertyStatus status) {
        Property property = propertyRepo.findById(id);
        property.setPropertyStatus(status);
        propertyRepo.save(property);
    }
}
