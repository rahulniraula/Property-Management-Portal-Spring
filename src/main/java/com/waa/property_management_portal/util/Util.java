package com.waa.property_management_portal.util;

import com.sendgrid.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public  static List<String> getLoggedUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            List<String> collect = authorities.stream().map(a -> a.getAuthority()).collect(Collectors.toList());
            return collect;
        }
        return null;
    }
    public static boolean loggedInUserHasRole(String role) {
        List<String> loggedUserRoles = Util.getLoggedUserRoles();
        if (loggedUserRoles!=null){
            return loggedUserRoles.contains(role);
        }
        return false;
    }

    public static String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return null;
    }
}
