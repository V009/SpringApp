package org.vignesh.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.vignesh.capp.dao.BaseDAO;
import org.vignesh.capp.dao.UserDAO;
import org.vignesh.capp.domain.User;
import org.vignesh.capp.exception.UserBlockedException;
import org.vignesh.capp.rm.UserRowMapper;


@Service
public class UserServiceImpl extends BaseDAO implements UserService{

	 @Autowired
	private UserDAO userDAO;
	
	public void register(User u) {
		userDAO.save(u);// TODO Auto-generated method stub
		
	}

	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName"
                + " FROM user WHERE loginName=:ln AND password=:pw";
        Map m = new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
            } else {
                return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
}
	}

	public List<User> getUserList() {
		 return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		 String sql = "UPDATE user SET loginStatus=:lst WHERE userId=:uid";
	        Map m = new HashMap();
	        m.put("uid", userId);
	        m.put("lst", loginStatus);
	getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	public Boolean isUsernameExist(String username) {
		 String sql = "SELECT count(loginName) FROM user WHERE loginName=?";
	        Integer count = getJdbcTemplate().queryForObject(sql, new String[]{username}, Integer.class);
	        if(count==1){
	            return true;
	        }else{
	            return false;
	}
	}

}
