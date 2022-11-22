package com.waa.property_management_portal.entity;

import com.waa.property_management_portal.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    private String password;
    private UserStatus status;

    @CreatedDate
    private LocalDateTime creationDate;

    @OneToOne(mappedBy = "user")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    @OneToMany(mappedBy = "owner")
    private List<Property> properties;
}
