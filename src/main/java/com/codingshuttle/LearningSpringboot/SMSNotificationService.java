package com.codingshuttle.LearningSpringboot;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("smsNotificationService")
@ConditionalOnProperty(name = "notification.service.type", havingValue = "sms", matchIfMissing = true)
public class SMSNotificationService implements NotificationService {
          @Override
          public void sendNotification(String message) {
                    System.out.println("SMS Notification: " + message);
          }
}