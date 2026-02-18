package com.example.SCMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.SCMS", "com.example.Smart_Clinic_Management_System" })
@EntityScan(basePackages = { "com.example.SCMS", "com.example.Smart_Clinic_Management_System" })
@EnableJpaRepositories(basePackages = { "com.example.SCMS", "com.example.Smart_Clinic_Management_System" })
public class SmartClinicManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartClinicManagementSystemApplication.class, args);
	}

}
