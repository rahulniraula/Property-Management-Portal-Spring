package com.waa.property_management_portal.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDetailsDto {
    @Id
    private long id;
    private int noOfRooms;
    @Temporal(TemporalType.DATE)
    private Date buildDate;
    private String heatingSystem;
    private String coolingSystem;
    private String parking;
    private String description;
    private int noOfViews;
}
