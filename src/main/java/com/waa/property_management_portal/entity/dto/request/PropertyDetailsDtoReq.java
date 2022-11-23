package com.waa.property_management_portal.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDetailsDtoReq {
    private long id;

    @DecimalMin(message = "Please provide number of rooms.", value = "1")
    private int noOfRooms;

    @NotEmpty(message = "Please provide type of the home.")
    private String homeType;

    @NotEmpty(message = "Please provide a build date.")
    private Date buildDate;

    @NotEmpty(message = "Please provide heating system.")
    private String heatingSystem;

    @NotEmpty(message = "Please provide cooling system.")
    private String coolingSystem;

    @NotEmpty(message = "Please provide parking info.")
    private String parking;

    @NotEmpty(message = "Please provide details of the property.")
    private String description;
}
