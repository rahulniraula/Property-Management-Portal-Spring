package com.waa.property_management_portal.entity.dto.response;

import com.waa.property_management_portal.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDtoResponse {
    private long id;
    private double price;
    private String message;
    private int propertyId;
    private List<String> actions;
    private PropertyDtoRes property;
    private OfferStatus status;
}
