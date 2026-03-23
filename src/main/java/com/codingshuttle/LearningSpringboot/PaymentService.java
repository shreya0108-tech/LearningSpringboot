package com.codingshuttle.LearningSpringboot;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
          public void pay(double amount) {
                    System.out.println("Processing payment of $" + amount);
          }
}