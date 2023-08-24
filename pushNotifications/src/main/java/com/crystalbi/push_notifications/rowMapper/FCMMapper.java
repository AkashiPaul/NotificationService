package com.crystalbi.push_notifications.rowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crystalbi.push_notifications.model.FCMSDK;

public class FCMMapper implements RowMapper<FCMSDK>{

	@Override
	public FCMSDK mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FCMSDK sdk = new FCMSDK();
		sdk.setSdk_name(rs.getString("sdk_name"));
		sdk.setProject_id(rs.getString("project_id"));
		return sdk;
	}

}
