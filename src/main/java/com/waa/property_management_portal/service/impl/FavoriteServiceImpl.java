package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.Favorite;
import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.FavoriteDto;
import com.waa.property_management_portal.repository.FavoriteRepo;
import com.waa.property_management_portal.repository.PropertyRepo;
import com.waa.property_management_portal.repository.UserRepo;
import com.waa.property_management_portal.service.FavoriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FavoriteRepo favoriteRepo;

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FavoriteDto> findFavorites(AwesomeUserDetails userDetails) {
        User user = userRepo.findByEmail(userDetails.getUsername());
        return user.getFavorites().stream().map(f->modelMapper.map(f,FavoriteDto.class)).collect(Collectors.toList());
    }

    @Override
    public void addFavorite(AwesomeUserDetails userDetails, FavoriteDto fav) {
        Favorite favorite = modelMapper.map(fav, Favorite.class);
        User user = userRepo.findByEmail(userDetails.getUsername());
        favorite.setUser(user);
        favoriteRepo.save(favorite);
    }

    @Override
    public void addPropertyToFavorite(AwesomeUserDetails userDetails, long id, long propId) {
        User user = userRepo.findByEmail(userDetails.getUsername());
        Favorite favorite = favoriteRepo.findById(id);
        Property property = propertyRepo.findById(propId);
        favorite.setUser(user);
        favorite.getProperties().add(property);
        favoriteRepo.save(favorite);
    }
}
