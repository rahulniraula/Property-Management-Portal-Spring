package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepo extends JpaRepository<Offer,Long> {
}
