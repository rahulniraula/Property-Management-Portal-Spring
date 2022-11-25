package com.waa.property_management_portal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class PropertyManagementPortalSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyManagementPortalSpringApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public JavaMailSender javaMailSender(){
        return new JavaMailSenderImpl();
    }

}
