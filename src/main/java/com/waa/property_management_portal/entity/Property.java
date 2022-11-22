package com.waa.property_management_portal.entity;

import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;
    private String title;
    private double area;
    private PropertyType propertyType;

    @OneToOne
    private Address address;

    @ManyToOne
    private User owner;

    @OneToOne
    private PropertyDetails details;
}
