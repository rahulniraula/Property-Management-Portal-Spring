package com.waa.property_management_portal.entity.dto.response;

import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDtoRes {
    private long id;
    private double price;
    private String title;
    private double area;
    private PropertyType propertyType;
}
