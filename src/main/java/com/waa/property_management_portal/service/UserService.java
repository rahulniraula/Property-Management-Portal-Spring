package com.waa.property_management_portal.service;

<<<<<<< HEAD
import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.UserDto;
=======
import com.waa.property_management_portal.entity.dto.response.UserDto;
>>>>>>> af9427a643c26b3cab160e4d0c7b2f251023f621

import java.util.List;

public interface UserService {
<<<<<<< HEAD
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void addUser(UserDto userDto);

    void deleteById(long userId);

    void updateUser(User user, long id);
=======
    List<UserDto> findAll();

    UserDto findById(long id);

    void deleteById(long id);

    void save(UserDto u);

>>>>>>> af9427a643c26b3cab160e4d0c7b2f251023f621
}
