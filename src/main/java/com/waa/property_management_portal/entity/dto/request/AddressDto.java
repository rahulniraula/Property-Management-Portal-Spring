package com.waa.property_management_portal.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private long id;
    @NotEmpty(message = "Please provide street.")
    private String street;
    @NotEmpty(message = "Please provide a city.")
    private String city;
    @NotEmpty(message = "Please provide a state.")
    private String state;
    @NotEmpty(message = "Please provide a zip code.")
    private String zipCode;
    @NotEmpty(message = "Please provide a country")
    private String country;
}
