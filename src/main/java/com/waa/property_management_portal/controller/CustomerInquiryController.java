package com.waa.property_management_portal.controller;


import com.waa.property_management_portal.entity.CustomerInquiry;
import com.waa.property_management_portal.service.CustomerInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CustomerInquiryController {
    @Autowired
    private CustomerInquiryService customerInquiryService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerInquiry> getAllCustomerInquiry(){
        return customerInquiryService.getAllCustomerInquiry();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CustomerInquiry> getCustomerInquiryById(@PathVariable("id") long id){
        return customerInquiryService.getCustomerInquiryById(id);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomerInquiry(@RequestBody CustomerInquiry customerInquiry){
        customerInquiryService.addCustomerInquiry(customerInquiry);
    }
    @PutMapping("/{id}")
    public void updateCustomerInquiry(@PathVariable("id") long id, CustomerInquiry customerInquiry){
        customerInquiryService.updateCustomerInquiry(id,customerInquiry);
    }
    @DeleteMapping("/{id}")
    public void deleteByCustomerInquiryId(@PathVariable("id") long id){
        customerInquiryService.deleteByCustomerInquiryId(id);
    }

}
