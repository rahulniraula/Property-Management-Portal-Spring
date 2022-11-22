package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import java.util.List;

public interface UserService {
    List<UserDtoRequest> findAll();

    UserDtoRequest findById(long id);

    void deleteById(long id);

    User save(UserDtoRequest u);

    void update(long id, UserDtoRequest user);
}
