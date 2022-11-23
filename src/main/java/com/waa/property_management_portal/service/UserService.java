package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.Favorite;
import com.waa.property_management_portal.entity.Property;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;

import java.util.List;

public interface UserService {
    List<UserDtoResponse> findAll();

    UserDtoResponse findById(long id);

    void deleteById(long id);

    User save(UserDtoRequest u);

    void update(long id, UserDtoRequest user);

    List<Property> findProperties(long id);

    List<Favorite> findFavorites(long id);
}
