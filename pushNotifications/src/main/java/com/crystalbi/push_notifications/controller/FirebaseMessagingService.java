package com.crystalbi.push_notifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalbi.push_notifications.model.NotificationMessage;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FirebaseMessagingService {
	
	@Autowired
	private FirebaseMessaging firebaseMessaging;
	
	public String sendNotificationByToken(NotificationMessage notificationMessage) {
		Notification notification = Notification
				.builder()
				.setTitle(notificationMessage.getTitle())
				.setBody(notificationMessage.getBody())
				.setImage(notificationMessage.getImage())
				.build();
		
		Message message = Message
				.builder()
				.setToken(notificationMessage.getToken())
				.setNotification(notification)
				.putAllData(notificationMessage.getData())
				.build();
	
		try {
			firebaseMessaging.send(message);
			return "Success sending notification!";
			
		}catch(FirebaseMessagingException e) {
			e.printStackTrace();
			return "Error sending notification!";
			
		}
				
	}
	

}
