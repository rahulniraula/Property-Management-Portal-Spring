package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property, Long> {
}
