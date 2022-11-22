package com.waa.property_management_portal.service;

import com.waa.property_management_portal.entity.CustomerInquiry;

import java.util.List;
import java.util.Optional;

public interface CustomerInquiryService{
    List<CustomerInquiry> getAllCustomerInquiry();

    Optional<CustomerInquiry> getCustomerInquiryById(long id);

    void addCustomerInquiry(CustomerInquiry customerInquiry);

    void updateCustomerInquiry(long id, CustomerInquiry customerInquiry);

    void deleteByCustomerInquiryId(long id);
}
