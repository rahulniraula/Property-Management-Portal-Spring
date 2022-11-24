package com.waa.property_management_portal.controller;

import com.waa.property_management_portal.entity.Favorite;
import com.waa.property_management_portal.entity.dto.request.FavoriteDto;
import com.waa.property_management_portal.service.FavoriteService;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/")
    public List<Favorite> getFavorites(@AuthenticationPrincipal AwesomeUserDetails user) {
        return favoriteService.findFavorites(user);
    }

    @PostMapping("/")
    public void addFavorite(@AuthenticationPrincipal AwesomeUserDetails user, @RequestBody FavoriteDto fav) {
        favoriteService.addFavorite(user, fav);
    }

    @PostMapping("/{id}/{propId}")
    public void addPropertyToFavorite(@AuthenticationPrincipal AwesomeUserDetails user,
                                      @PathVariable long id,
                                      @PathVariable long propId) {
        favoriteService.addPropertyToFavorite(user, id, propId);
    }
}
