package com.waa.property_management_portal.service.impl;

import com.waa.property_management_portal.entity.EmailDetails;
import com.waa.property_management_portal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    //@Autowired
    @Autowired
    private JavaMailSender mailSender;
//    private EmailServiceImpl(JavaMailSender mailSender){
//        this.mailSender=mailSender;
//    }

    @Value("${spring.mail.username}") private String sender;

    // Method 1
    // To send a simple email
    public String sendMail(EmailDetails details)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            mailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}
