package com.waa.property_management_portal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    private Byte status;
}
