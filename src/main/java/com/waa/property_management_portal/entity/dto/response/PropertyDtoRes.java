package com.waa.property_management_portal.entity.dto.response;

import com.waa.property_management_portal.entity.Image;
import com.waa.property_management_portal.entity.PropertyDetails;
import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDtoRes {
    private long id;
    private double price;
    private String title;
    private double area;
    private PropertyType propertyType;
    private List<String> actions;
    private PropertyDetailsDtoResponse details;
    private boolean offered;
    private PropertyStatus status;
    private List<ImageDTO> images;
}
