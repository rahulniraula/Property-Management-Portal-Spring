package com.waa.property_management_portal.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String firstname;
    private String lastname;
}
