package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private long id;
    private double price;
    private String title;
    private double area;
    private PropertyType propertyType;
    private PropertyDetails details;
}
