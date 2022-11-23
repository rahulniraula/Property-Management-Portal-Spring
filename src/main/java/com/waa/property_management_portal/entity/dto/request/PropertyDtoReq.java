package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.entity.Address;
import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.enums.PropertyType;

import javax.validation.constraints.NotEmpty;

public class PropertyDtoReq {
    private long id;

    @NotEmpty(message = "Please provide a price for the property.")
    private double price;

    @NotEmpty(message = "Please provide a title for the property.")
    private String title;

    @NotEmpty(message = "Please provide area in sqft unit.")
    private double area;

    private PropertyType propertyType;
    private Address address;

    private PropertyDetails details;
}
