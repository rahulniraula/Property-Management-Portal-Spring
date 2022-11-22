package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoRequest {
    private long id;
    @Email(message = "Please enter a valid email message")
    @NotEmpty(message = "Email field cannot be empty")
    private String email;
    @NotEmpty(message = "First Name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be Empty")
    private String lastName;
    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneNumber;
    @NotEmpty(message = "Password cannot be empty")
    @Min(message = "Password cannot be less than 4", value = 4)
    private String password;
//    @NotEmpty(message = "Please provide user role")
    private UserRole role;
}
