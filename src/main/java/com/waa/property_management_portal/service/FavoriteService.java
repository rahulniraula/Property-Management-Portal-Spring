package com.waa.property_management_portal.service;


import com.waa.property_management_portal.entity.Favorite;
import com.waa.property_management_portal.entity.dto.request.FavoriteDto;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDto> findFavorites(AwesomeUserDetails user);

    void addFavorite(AwesomeUserDetails user, FavoriteDto fav);

    void addPropertyToFavorite(AwesomeUserDetails user, long id, long propId);
}
