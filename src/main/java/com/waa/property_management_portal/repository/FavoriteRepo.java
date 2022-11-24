package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
    Favorite findById(long id);

    Favorite findByName(String name);
}
