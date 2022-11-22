package com.waa.property_management_portal.filter;

import com.waa.property_management_portal.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    private final UserDetailsService userDetailsService;

    public JwtFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        String email = null;
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            try{
                email = jwtUtil.getUsernameFromToken(token);
            }catch (ExpiredJwtException e){
                System.out.println("JWT is expired now try refresh token");
                String refreshTokenHeader = request.getHeader("refreshToken");
                if(refreshTokenHeader != null){
                    try{
                        email = jwtUtil.getUsernameFromToken(refreshTokenHeader);
                        System.out.println("In Refresh part");
                        var userDetails= userDetailsService.loadUserByUsername(email);
                        token = jwtUtil.generateToken(userDetails);
                        var refreshToken= jwtUtil.generateRefreshToken(userDetails.getUsername());
                        response.setHeader("refreshToken", refreshToken);
                        response.setHeader("accessToken", token);
                    }catch (ExpiredJwtException ex){
                        System.out.println("Refresh token is also expired"+ex.getMessage());
                    }
                }
            }
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = userDetailsService.loadUserByUsername(email);
            boolean isTokenValid = jwtUtil.validateToken(token);
            if (isTokenValid) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}