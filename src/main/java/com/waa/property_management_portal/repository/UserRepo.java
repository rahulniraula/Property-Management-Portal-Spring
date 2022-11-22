package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByEmail(String username);
}
