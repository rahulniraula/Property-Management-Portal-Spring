package com.waa.property_management_portal.entity;

import com.waa.property_management_portal.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;
    private String message;
    @CreatedDate
    private LocalDateTime offerDate;

    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    @Transient
    private List<String> actions;
    public List<String> getActions() {
        List<String> actions = new ArrayList<>();
        if(!getStatus().name().equals(OfferStatus.ACCEPTED.name())){
            actions.add("Accept Offer");
            actions.add("Reject Offer");
        }
        return actions;
    }
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
