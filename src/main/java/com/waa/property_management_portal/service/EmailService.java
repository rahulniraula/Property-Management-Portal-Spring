package com.waa.property_management_portal.service;


import com.sendgrid.Response;
import com.waa.property_management_portal.entity.EmailDetails;

public interface EmailService {
    Response sendEmail(EmailDetails details);
}
