package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.entity.dto.request.LoginRequest;
import com.waa.property_management_portal.entity.dto.request.RefreshTokenRequest;
import com.waa.property_management_portal.entity.dto.request.UserDtoRequest;
import com.waa.property_management_portal.entity.dto.response.LoginResponse;
import com.waa.property_management_portal.entity.dto.response.UserDtoResponse;
import com.waa.property_management_portal.service.AuthService;
import com.waa.property_management_portal.service.UserService;
import com.waa.property_management_portal.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getEmail());

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        return new LoginResponse(accessToken, refreshToken);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid= jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if(isRefreshTokenValid){
            var isAccessTokenExpired=jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if(isAccessTokenExpired){
                System.out.println("Access Token is expired");
            }else{
                System.out.println("Access token is not expired");
            }
            final String accessToken=jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            return new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
        }
        return new LoginResponse();
    }

    @Override
    public UserDtoResponse registerUser(UserDtoRequest u) {
        User user = userService.save(u);
        return modelMapper.map(user, UserDtoResponse.class);
    }
}
