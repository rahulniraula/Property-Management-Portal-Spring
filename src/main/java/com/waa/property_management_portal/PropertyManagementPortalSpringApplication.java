package com.waa.property_management_portal;

import com.waa.property_management_portal.entity.User;
import com.waa.property_management_portal.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
public class PropertyManagementPortalSpringApplication {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(PropertyManagementPortalSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            User user = userRepo.findById(111);
            if (user == null) {
                log.info("Initializing data.sql for the FIRST TIME");
                Resource initSql = new ClassPathResource("data.sql");
                DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSql);
                DatabasePopulatorUtils.execute(databasePopulator, dataSource);
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }

}
