package com.waa.property_management_portal.controller.public_access;

import com.waa.property_management_portal.entity.EmailDetails;
import com.waa.property_management_portal.entity.dto.request.MessageDto;
import com.waa.property_management_portal.service.EmailService;
import com.waa.property_management_portal.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/public/messages")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
public class MessageController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/{propId}")
    public void sendMessage(@PathVariable long propId, @RequestBody MessageDto message) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name : " + message.getFullName() + "\n");
        sb.append("Email : " + message.getEmail() + "\n");
        sb.append("Phone : " + message.getPhone() + "\n");
        sb.append("Message : " + message.getMessage() + "\n");

        String subject = "Basic inquiry about your property";

        String ownerEmail = propertyService.getUserEmail(propId);
        emailService.sendEmail(new EmailDetails(ownerEmail, subject, sb.toString()));
    }
}
