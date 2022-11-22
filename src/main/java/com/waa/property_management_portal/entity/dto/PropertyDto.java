package com.waa.property_management_portal.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    @Id
    private long id;
    private double price;
    private String location;
    private String title;
    private double area;
    private String propertyType;

    // private long ownerId;
}
