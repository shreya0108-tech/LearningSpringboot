package com.codingshuttle.LearningSpringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Service
//@ConditionalOnProperty(name = "notification.service.type", havingValue = "email", matchIfMissing = false)
public class EmailNotificationService implements NotificationService {
          @Override
          public void sendNotification(String message) {
                    System.out.println("Email Notification: " + message);
          }
}