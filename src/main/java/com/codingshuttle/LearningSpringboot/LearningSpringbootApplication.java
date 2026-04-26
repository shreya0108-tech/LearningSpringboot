package com.codingshuttle.LearningSpringboot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LearningSpringbootApplication implements CommandLineRunner {

	@Autowired
	PaymentService paymentService;

	//@Qualifier("smsNotificationService")
	// @Autowired
	// NotificationService notificationService;
	@Autowired
	Map<String, NotificationService> notificationServices;

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringbootApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		paymentService.pay(100);
		System.out.println("Hash code of paymentService: " + paymentService.hashCode());
		// notificationService.sendNotification("Payment successful!");

		// The compiler automatically infers the type based on the value assigned to it using 'var', it was introduced in Java 10.
		for(var notificationService : notificationServices.entrySet()) {
			System.out.println(notificationService.getKey()); 
			notificationService.getValue().sendNotification("Payment Successful");
		}
	}
}