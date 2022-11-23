package com.waa.property_management_portal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int noOfRooms;
    private String homeType;
    @Temporal(TemporalType.DATE)
    private Date buildDate;
    private String heatingSystem;
    private String coolingSystem;
    private String parking;
    private String description;
    private long noOfViews;

    @OneToOne
    private Property property;

}
