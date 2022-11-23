package com.waa.property_management_portal.entity.dto.request;

import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDtoReq {
    private long id;

    @DecimalMin(message = "Please provide a price for the property.",value = "10")
    private double price;

    @NotEmpty(message = "Please provide a title for the property.")
    private String title;

    @DecimalMin(message = "Please provide area in sqft unit.", value = "10")
    private double area;

    @NotNull
    private PropertyType propertyType;

//    @Valid
    private AddressDto address;

    @DecimalMin(message = "Please provide number of rooms.", value = "1")
    private int noOfRooms;

    @NotNull(message = "You should provide built date")
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
