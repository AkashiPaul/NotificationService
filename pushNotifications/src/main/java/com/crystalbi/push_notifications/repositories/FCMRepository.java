package com.crystalbi.push_notifications.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crystalbi.push_notifications.model.FCMSDK;
import com.crystalbi.push_notifications.model.FCMTOKEN;
import com.crystalbi.push_notifications.model.FCM_TOKEN_Join;
import com.crystalbi.push_notifications.rowMapper.FCMMapper;
import com.crystalbi.push_notifications.rowMapper.FCMTokenMapper;
import com.crystalbi.push_notifications.rowMapper.FCM_TOKEN_JOIN_RowMapper;

@Repository
public class FCMRepository {
	
	@Autowired
	private JdbcTemplate  jdbcTemplate;
		
		/*
		 * Add FirebaseSDK name
		 * and product id to the database
		 */
	public void addSDK(FCMSDK sdk) {
		try {
				String query = "insert into FCMSDK(sdk_name , project_id) values(?,?)";
				int rowCount = jdbcTemplate.update(query ,sdk.getSdk_name(), sdk.getProject_id());
				if(rowCount > 0) {
				System.out.println("Added your sdk to the database");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		/*
		 * Fetch FirebaseSDK name and 
		 * Product Id from the database;
		 */
	public List<FCMSDK> getAllSDK(){
		List<FCMSDK> sdkList = jdbcTemplate.query("select * from FCMSDK", new FCMMapper());
		return sdkList;
	}
	
		/*
		 * Add Device Token
		 * and Firebase product id to the database
		 */
	public void addTokens(String token , String product_id) {
		
		try {
			 
		    	 String query = "insert into FCMTOKEN(token,project_id) values(?,?)";
					int rowCount = jdbcTemplate.update(query , token , product_id);
					if(rowCount > 0) {
						System.out.print("Token and Product id is added to the database successfully");
						
					}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		/*
		 * Fetch Device token and 
		 * Product Id from the database;
		 */
	public List<FCMTOKEN> getAllTOkens(){
		List<FCMTOKEN> tokenList = jdbcTemplate.query("select * from FCMTOKEN", new FCMTokenMapper());
		return tokenList;
	}
	
	/*
	 * Fetch Tokens by ProductID
	 */
	
	public List<FCM_TOKEN_Join> getTokensByProductId(String project_id){
		
		 String query = "select token.token , token.project_id , sdk.sdk_name from FCMTOKEN token join FCMSDK sdk on token.project_id = sdk.project_id where token.project_id = ?";
		    List<FCM_TOKEN_Join> tokens = jdbcTemplate.query(query, new FCM_TOKEN_JOIN_RowMapper(), project_id);
		    return tokens;
	}
	
//	/*
//	 * Get Device By Token
//	 */
//	
//	public List<FCMTOKEN> getProductIdByToken(String token) {
//		String query = "select * from FCMTOKEN where token = ?";
//		List<FCMTOKEN> list = jdbcTemplate.query(query, new FCMTokenMapper() ,token);
//		return list;
//	}
//	
	
	
	

}
