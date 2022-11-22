package com.waa.property_management_portal.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
