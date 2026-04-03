package com.codingshuttle.LearningSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LearningSpringbootApplication implements CommandLineRunner {

	@Autowired
	PaymentService paymentService;

	//@Qualifier("smsNotificationService")
	@Autowired
	NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringbootApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		paymentService.pay(100);
		System.out.println("Hash code of paymentService: " + paymentService.hashCode());
		notificationService.sendNotification("Payment successful!");
	}
}