package com.crystalbi.push_notifications;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@SpringBootApplication()
public class PushNotificationsApplication {
 
	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException {
		GoogleCredentials googleCredentials = GoogleCredentials.fromStream(
				new ClassPathResource("push-notifications-27933-firebase-adminsdk-6kr14-a1eaaadaab.json").getInputStream());
	
		FirebaseOptions firebaseOptions = FirebaseOptions.builder()
				.setCredentials(googleCredentials).build();
		
		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions,"my-app");
		return FirebaseMessaging.getInstance(app);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(PushNotificationsApplication.class, args);
	}

}
