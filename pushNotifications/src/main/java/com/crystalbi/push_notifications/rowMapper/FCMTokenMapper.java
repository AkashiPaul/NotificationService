package com.crystalbi.push_notifications.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crystalbi.push_notifications.model.FCMTOKEN;

public class FCMTokenMapper implements RowMapper<FCMTOKEN> {

	@Override
	public FCMTOKEN mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FCMTOKEN token = new FCMTOKEN();
		token.setToken(rs.getString("token"));
		token.setProject_id(rs.getString("project_id"));
		return token;
	}

}
