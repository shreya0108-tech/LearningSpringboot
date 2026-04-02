package com.codingshuttle.LearningSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LearningSpringbootApplication implements CommandLineRunner {

	@Autowired
	PaymentService paymentService;

	@Autowired
	PaymentService paymentService2;

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringbootApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		paymentService.pay(100);
		paymentService2.pay(200);
		System.out.println("Hash code of paymentService: " + paymentService.hashCode());
		System.out.println("Hash code of paymentService2: " + paymentService2.hashCode());
	}
}