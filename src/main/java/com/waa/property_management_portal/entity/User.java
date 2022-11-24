package com.waa.property_management_portal.entity;

import com.waa.property_management_portal.enums.UserRole;
import com.waa.property_management_portal.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @CreatedDate
    private LocalDateTime creationDate;

    @OneToOne(mappedBy = "user")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles=new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Property> properties;

    public void addRole(Role role){
        this.roles.add(role);
    }

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    private List<Offer> offers;

    @Transient
    private List<String> actions;
    public List<String> getActions(){
        List<String> actions=new ArrayList<>();
        if(isRole(UserRole.ADMIN.name()) && this.getStatus()!=null){
            if(this.getStatus().equals(UserStatus.ACTIVE)){
                actions.add(UserStatus.INACTIVE.name());
                actions.add("Reset Password");
//                actions.add("Edit User");
//                actions.add("Delete User");
            }else{
                actions.add(UserStatus.ACTIVE.name());
            }
        }
        return actions;
    }
    public boolean isRole(String role){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            List<String> collect = authorities.stream().map(a -> a.getAuthority()).collect(Collectors.toList());
            return collect.contains(role);
        }
        return false;
    }
}
