package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.entity.Address;
import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDtoReq {
    private long id;

    @NotEmpty(message = "Please provide a price for the property.")
    private double price;

    @NotEmpty(message = "Please provide a title for the property.")
    private String title;

    @NotEmpty(message = "Please provide area in sqft unit.")
    private double area;

    @NotEmpty(message = "Please select a property type.")
    private PropertyType propertyType;

    private AddressDto address;

    private PropertyDetailsDtoReq details;
}
