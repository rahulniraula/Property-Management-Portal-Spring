package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void addUser(UserDto userDto);

    void deleteById(long userId);

    void updateUser(User user, long id);
}
