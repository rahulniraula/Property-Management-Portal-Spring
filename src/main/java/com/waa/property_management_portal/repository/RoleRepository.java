package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String name);
}
