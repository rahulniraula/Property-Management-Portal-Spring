package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.PasswordDto;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.OfferDtoResponse;
import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;
import com.waa.property_management_portal.enums.UserStatus;
import com.waa.property_management_portal.service.impl.AwesomeUserDetails;

import java.util.List;

public interface UserService {
    List<UserDtoResponse> findAll();

    UserDtoResponse findById(long id);

    void deleteById(long id);

    User save(UserDtoRequest u);

    void update(long id, UserDtoRequest user);

    List<PropertyDtoRes> findProperties(long id);

    void updateStatus(long id, UserStatus status);
    public List<OfferDtoResponse> getOffers(AwesomeUserDetails user,long id);

    void resetPassword(long id, PasswordDto newPassword);
}
