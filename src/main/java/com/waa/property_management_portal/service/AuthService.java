package com.waa.property_management_portal.service;


import com.waa.property_management_portal.entity.dto.request.LoginRequest;
import com.waa.property_management_portal.entity.dto.request.RefreshTokenRequest;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.LoginResponse;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    UserDtoResponse registerUser(UserDtoRequest user);
}
