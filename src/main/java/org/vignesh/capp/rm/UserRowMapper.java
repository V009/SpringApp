package org.vignesh.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.vignesh.capp.domain.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int i) throws SQLException {
		// TODO Auto-generated method stub
		User u= new User();
		u.setUserId(rs.getInt("UserId"));
		u.setName(rs.getString("name"));
		u.setPhone(rs.getString("phone"));
		u.setEmail(rs.getString("email"));
		u.setAddress(rs.getString("address"));
		u.setLoginName(rs.getString("loginName"));
		u.setRole(rs.getInt("role"));
		u.setLoginStaus(rs.getInt("loginStatus"));
		return u;
		
	}

}
