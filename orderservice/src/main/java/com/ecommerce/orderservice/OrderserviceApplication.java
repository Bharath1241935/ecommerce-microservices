package com.ecommerce.orderservice;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderserviceApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println(
		        "JVM TimeZone: " + java.util.TimeZone.getDefault().getID()
		    );
		SpringApplication.run(OrderserviceApplication.class, args);
	}

}
