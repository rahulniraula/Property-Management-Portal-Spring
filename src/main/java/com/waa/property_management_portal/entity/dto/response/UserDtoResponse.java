package com.waa.property_management_portal.entity.dto.response;

import com.waa.property_management_portal.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {
    private long id;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private String phoneNumber;
    private List<Role> roles;
}
