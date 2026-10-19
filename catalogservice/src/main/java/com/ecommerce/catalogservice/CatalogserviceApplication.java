package com.ecommerce.catalogservice;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogserviceApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println(
		        "JVM TimeZone: " + java.util.TimeZone.getDefault().getID()
		    );
		SpringApplication.run(CatalogserviceApplication.class, args);
	}

}
