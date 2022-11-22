package com.waa.property_management_portal.entity.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class LoginRequest {
    @NotEmpty(message = "Please provide a valid Email Address")
    @Email(message = "Please provide a well-formed email address")
    private String email;
    @NotEmpty(message = "Please provide a valid Password")
    private String password;
}
