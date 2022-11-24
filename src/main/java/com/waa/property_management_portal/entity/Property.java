package com.waa.property_management_portal.entity;

import com.waa.property_management_portal.enums.PropertyStatus;
import com.waa.property_management_portal.enums.PropertyType;
import com.waa.property_management_portal.enums.UserRole;
import com.waa.property_management_portal.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    @OneToOne(cascade = CascadeType.ALL)
    private PropertyDetails details;

    @OneToMany(mappedBy = "property")
    private List<Image> images;
    @OneToMany(mappedBy = "property")
    private List<Offer> offers;
    @Transient
    private boolean offered;
    private boolean getOffered() {
        String username = Util.getLoggedInUserName();
        if (this.getOffers()
                .stream()
                .anyMatch(offer -> offer.getUser().getEmail().equals(username))){
            return true;
        }
        return false;
    }
    @Transient
    private List<String> actions;
    public List<String> getActions(){
        List<String> actions=new ArrayList<>();
        if(getPropertyStatus().name().equals(PropertyStatus.ACTIVE.name()) || getPropertyStatus().name().equals(PropertyStatus.INACTIVE.name())){
            actions.add("Delete Property");
            actions.add("Edit Property");
        }
//        if(Util.loggedInUserHasRole(UserRole.ADMIN.name())){
//            if(getPropertyStatus().name().equals(PropertyStatus.PENDING.name())){
//
//            }
//        } else if (Util.loggedInUserHasRole(UserRole.OWNER.name())) {
//        }
        return actions;
    }
}
