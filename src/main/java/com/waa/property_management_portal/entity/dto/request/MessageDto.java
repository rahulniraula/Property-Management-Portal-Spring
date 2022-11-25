package com.waa.property_management_portal.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private String fullName;
    private String email;
    private String phone;
    private String message;
}
