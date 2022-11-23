package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.entity.Address;
import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.enums.PropertyType;

public class PropertyDtoReq {
    private long id;
    private double price;
    private String title;
    private double area;
    private PropertyType propertyType;
    private Address address;

    private PropertyDetails details;
}
