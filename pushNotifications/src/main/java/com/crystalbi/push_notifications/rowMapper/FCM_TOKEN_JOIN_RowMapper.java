package com.crystalbi.push_notifications.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crystalbi.push_notifications.model.FCMSDK;
import com.crystalbi.push_notifications.model.FCM_TOKEN_Join;

public class FCM_TOKEN_JOIN_RowMapper implements RowMapper<FCM_TOKEN_Join> {

	@Override
	public FCM_TOKEN_Join mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FCM_TOKEN_Join join = new FCM_TOKEN_Join();
		FCMSDK sdk = new FCMSDK();
		
		join.setProject_id(rs.getString("project_id"));
		join.setToken(rs.getString("token"));
		sdk.setSdk_name(rs.getString("sdk_name"));
		join.setSdk_name(sdk.getSdk_name());
		
		return join;
	}

}
