package com.waa.property_management_portal.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDtoRequest {
    @DecimalMin(message = "Please enter your a reasonable price",value = "1")
//    @NotEmpty(message = "Please enter a valid price")
    private double price;
    @NotEmpty(message = "Please enter your message to the Owner")
    private String message;
    private int propertyId;
}
