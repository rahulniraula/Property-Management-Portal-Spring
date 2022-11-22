package com.waa.property_management_portal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    // if need another entity will be declared later
    private String address;
    private String contact;
    private String email;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private Byte status;

=======
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String password;
    String firstname;
    String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles;
>>>>>>> af9427a643c26b3cab160e4d0c7b2f251023f621
}
