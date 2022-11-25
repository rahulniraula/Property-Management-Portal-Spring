package com.waa.property_management_portal.service.impl;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.waa.property_management_portal.entity.EmailDetails;
import com.waa.property_management_portal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    SendGrid sendGrid;
    public Response sendEmail(EmailDetails emailDetail){
       Email from = new Email("sujan.a13@gmail.com");
       String subject = emailDetail.getSubject();
       Email to = new Email(emailDetail.getTo());
       Content content = new Content("text/plain", emailDetail.getBody());
       Mail mail = new Mail(from, subject, to, content);
       Request request = new Request();
        Response response=null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response=this.sendGrid.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch ( IOException ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

}
