package com.waa.property_management_portal.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDetailsDtoResponse {
    private long id;

    private int noOfRooms;

    private String homeType;

    private Date buildDate;

    private String heatingSystem;

    private String coolingSystem;

    private String parking;

    private String description;
}
