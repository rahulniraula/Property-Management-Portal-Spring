package com.waa.property_management_portal.entity;

import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double price;
    private double area;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    @OneToOne
    private Address address;

    @ManyToOne
    private User owner;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "property",fetch = FetchType.EAGER)
    private PropertyDetails details;

    @OneToMany(mappedBy = "property")
    private List<Image> images;
}
