package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Offer;
import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.OfferDtoRequest;
import com.waa.property_management_portal.entity.dto.request.PropertyDtoReq;
import com.waa.property_management_portal.entity.dto.response.OfferDtoResponse;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.enums.OfferStatus;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.enums.PropertyType;
import com.waa.property_management_portal.model.PropertySearchCriteria;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
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
    public List<PropertyDtoRes> findAllWithFilters(Map<String,String> searchCriteria) {
        System.out.println("In criteria");
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

    private Predicate getPredicate(Map<String,String> searchCriteria, Root<Property> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (searchCriteria.get("title")!=null && !searchCriteria.get("title").isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + searchCriteria.get("title") + "%"));
        }
        if(searchCriteria.get("propertyType")!=null && !searchCriteria.get("propertyType").isEmpty()){
            predicates.add(criteriaBuilder.equal(root.get("propertyType"), PropertyType.valueOf(searchCriteria.get("propertyType"))));
        }
        if(searchCriteria.get("propertyStatus")!=null && !searchCriteria.get("propertyStatus").isEmpty()){
            predicates.add(criteriaBuilder.equal(root.get("propertyStatus"), PropertyStatus.valueOf(searchCriteria.get("propertyStatus"))));
        }
        if(searchCriteria.get("maxPrice")!=null && !searchCriteria.get("maxPrice").isEmpty()){
            predicates.add(criteriaBuilder.le(root.get("price"),Integer.valueOf(searchCriteria.get("maxPrice"))));
        }
        if(searchCriteria.get("minPrice")!=null && !searchCriteria.get("minPrice").isEmpty()){
            predicates.add(criteriaBuilder.ge(root.get("price"),Integer.valueOf(searchCriteria.get("minPrice"))));
        }
//        if(searchCriteria.get("area")!=null && !searchCriteria.get("area").isEmpty()){
//            predicates.add(criteriaBuilder.le(root.get("area"),Integer.valueOf(searchCriteria.get("area"))));
//        }
//        if(searchCriteria.get("noOfRooms")!=null && !searchCriteria.get("noOfRooms").isEmpty()){
//            predicates.add(criteriaBuilder.le(root.get("noOfRooms"),Integer.valueOf(searchCriteria.get("noOfRooms"))));
//        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    @Override
    public void deleteById(long id) {
        Property property = propertyRepo.findById(id);
        if (property.getPropertyStatus().equals(PropertyStatus.PENDING)) {
            throw new RuntimeException("Sorry, you cannot remove property which is in pending status.");
        }
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
        property.setPropertyStatus(PropertyStatus.ACTIVE);
//        property.setAddress(modelMapper.map(p.getAddress(), Address.class));
        PropertyDetails propertyDetails = modelMapper.map(p, PropertyDetails.class);
        propertyDetails.setProperty(null);
        property.setDetails(propertyDetails);
        propertyRepo.save(property);
    }

    @Override
    public void updateStatus(long id, PropertyStatus status) {
        Property property = propertyRepo.findById(id);
        property.setPropertyStatus(status);
        propertyRepo.save(property);
    }
    public List<OfferDtoResponse> getOffers(long productId){
        Property property = propertyRepo.findById(productId);
        return property.getOffers().stream().map(o->modelMapper.map(o, OfferDtoResponse.class)).collect(Collectors.toList());
    }
    @Override
    public void cancelContingency(long id) {
        Property property = propertyRepo.findById(id);
        if(property.getPropertyStatus().equals(PropertyStatus.CONTINGENT)){
            property.setPropertyStatus(PropertyStatus.PENDING);
        }
        propertyRepo.save(property);
    }

    @Override
    public String getUserEmail(long id) {
        Property property = propertyRepo.findById(id);
        return property.getOwner().getEmail();
    }

}
