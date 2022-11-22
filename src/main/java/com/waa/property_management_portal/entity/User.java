package com.waa.property_management_portal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
