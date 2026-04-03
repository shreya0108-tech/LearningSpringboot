package com.codingshuttle.LearningSpringboot;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class PaymentService {
          public void pay(double amount) {
                    System.out.println("Processing payment of $" + amount);
          }

          @PostConstruct
          public void postInitialization() {
                    System.out.println("PaymentService has been initialized.");
          }

          @PreDestroy
          public void preDestruction() {
                    System.out.println("PaymentService is about to be destroyed.");
          }
}