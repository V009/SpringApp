package org.vignesh.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.vignesh.capp.domain.User;
import org.vignesh.capp.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	public void save(User u) {
		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
				+ " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());

		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer userId = kh.getKey().intValue();
		u.setUserId(userId);
	}

	public void update(User u) {
		String sql = "UPDATE USER " + "SET name=:name," + " phone=:phone, " + " email=:email," + " address=:address,"
				+ " role=:role," + " loginStatus=:loginStatus " + " WHERE userId=:userId";
	    Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());       
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        m.put("userId", u.getUserId());
getNamedParameterJdbcTemplate().update(sql, m);
		// TODO Auto-generated method stub

	}

	public void delete(User u) {
		 this.delete(u.getUserId());// TODO Auto-generated method stub

	}

	public void delete(Integer userId) {
		String sql="DELETE FROM user WHERE userId=?";
		getJdbcTemplate().update(sql, userId);// TODO Auto-generated method stub

	}

	public User findbyId(Integer userId) {
		// TODO Auto-generated method stub
		 String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
	                + " FROM user WHERE userId=?";
	        User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
	return u;
	}

	public List<User> findAll() {
		 String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
	                + " FROM user";
		 return  getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public List<User> findByProperty(String propName, Object propvalue) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE "+propName+"=?";
return getJdbcTemplate().query(sql, new UserRowMapper(), propvalue);
	}

}
