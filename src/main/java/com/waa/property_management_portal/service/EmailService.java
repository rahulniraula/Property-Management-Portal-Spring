package com.waa.property_management_portal.service;


import com.waa.property_management_portal.entity.EmailDetails;

public interface EmailService {
    String sendMail(EmailDetails details);
}
