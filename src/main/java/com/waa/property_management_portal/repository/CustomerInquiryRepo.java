package com.waa.property_management_portal.repository;

import com.waa.property_management_portal.entity.CustomerInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInquiryRepo  extends JpaRepository<CustomerInquiry, Long> {
    void updateCustomerInquiry(long id, CustomerInquiry customerInquiry);
}
