package com.crystalbi.push_notifications.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystalbi.push_notifications.model.FCMTOKEN;
import com.crystalbi.push_notifications.model.FCM_TOKEN_Join;
import com.crystalbi.push_notifications.model.NotificationMessage;
import com.crystalbi.push_notifications.repositories.FCMRepository;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	
	@Autowired
	private FCMRepository fcmRepository;
	
	@Autowired
	FirebaseMessagingService firebaseMessagingService;
	
	@PostMapping("/sendNotification")
	public String sendNotification(@RequestBody NotificationMessage message ) {
		return firebaseMessagingService.sendNotificationByToken(message);
	}
	
	
	@PostMapping("/sendToken")
	public void addTokenstoList(@RequestBody FCMTOKEN fcmtoken) {
		fcmRepository.addTokens(fcmtoken.getToken(), fcmtoken.getProject_id());
		
	}
	
	
	@GetMapping("/showAllTokens")
	public List<FCMTOKEN> getAllTOkens(){
		return fcmRepository.getAllTOkens();
		
	}
	
	@GetMapping("/getTokenByProductId/{project_id}")
	public List<FCM_TOKEN_Join> getTokenByProductId(@PathVariable String project_id){
		return fcmRepository.getTokensByProductId(project_id);
	}
	
//	@GetMapping("/getProductByToken/{id}")
//	public List<FCMTOKEN> getProductIdByToken(@PathVariable String token){
//		return fcmRepository.getProductIdByToken(token);
//		
//	}
	
	
	

}
