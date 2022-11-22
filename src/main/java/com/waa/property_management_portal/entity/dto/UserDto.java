package com.waa.property_management_portal.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Id
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

}
