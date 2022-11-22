package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.CustomerInquiry;
import com.waa.property_management_portal.repository.CustomerInquiryRepo;
import com.waa.property_management_portal.service.CustomerInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerInquiryServiceImpl implements CustomerInquiryService {
    @Autowired
    public CustomerInquiryRepo customerInquiryRepo;
    @Override
    public List<CustomerInquiry> getAllCustomerInquiry() {
        return customerInquiryRepo.findAll();
    }

    @Override
    public Optional<CustomerInquiry> getCustomerInquiryById(long id) {
        return customerInquiryRepo.findById(id);
    }

    @Override
    public void addCustomerInquiry(CustomerInquiry customerInquiry) {
        customerInquiryRepo.save(customerInquiry);
    }

    @Override
    public void updateCustomerInquiry(long id, CustomerInquiry customerInquiry) {
        customerInquiryRepo.updateCustomerInquiry(id, customerInquiry);
    }

    @Override
    public void deleteByCustomerInquiryId(long id) {
        customerInquiryRepo.deleteById(id);
    }
}
