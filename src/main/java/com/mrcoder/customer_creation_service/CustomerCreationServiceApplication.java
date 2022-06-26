package com.mrcoder.customer_creation_service;

import com.mrcoder.customer_creation_service.models.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerCreationServiceApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(CustomerCreationServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer= new Customer();
		customer.setCustomerName("Arun");
		System.out.println(customer.getCustomerName());

	}
}
