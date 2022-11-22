package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    void updateUser(User user, long id);
}