package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDtoReq {
    private long id;

    @DecimalMin(message = "Please provide a price for the property.",value = "10")
    private double price;

    @NotEmpty(message = "Please provide a title for the property.")
    private String title;

    @DecimalMin(message = "Please provide area in sqft unit.", value = "10")
    private double area;

//    @NotEmpty(message = "Please select a property type.")
    @NotNull
    private PropertyType propertyType;

    private AddressDto address;

    private PropertyDetailsDtoReq details;
}
