package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface UserRepo extends JpaRepository<User, Long> {

    void updateUser(User user, long id);
}
=======
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByEmail(String username);
}
>>>>>>> af9427a643c26b3cab160e4d0c7b2f251023f621
