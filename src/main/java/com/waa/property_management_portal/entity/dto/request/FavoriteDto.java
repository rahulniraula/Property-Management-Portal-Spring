package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.entity.dto.response.PropertyDtoRes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteDto {
    private Long id;
    private String name;
    List<PropertyDtoRes> properties;
}
