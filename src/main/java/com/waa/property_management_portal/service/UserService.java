package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.dto.request.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(long id);

    void deleteById(long id);

    void save(UserDto u);

    void update(long id, UserDto user);
}
