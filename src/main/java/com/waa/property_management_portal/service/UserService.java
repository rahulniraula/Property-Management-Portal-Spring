package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.Favorite;
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.FavoriteDto;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;
import com.waa.property_management_portal.enums.UserStatus;

import java.util.List;

public interface UserService {
    List<UserDtoResponse> findAll();

    UserDtoResponse findById(long id);

    void deleteById(long id);

    User save(UserDtoRequest u);

    void update(long id, UserDtoRequest user);

    List<PropertyDtoRes> findProperties(long id);

    List<Favorite> findFavorites(long id);

    void addFavorite(long id, FavoriteDto fav);

    void addPropertyToFavorite(long id, long favId, long propId);

    void updateStatus(long id, UserStatus status);
}
