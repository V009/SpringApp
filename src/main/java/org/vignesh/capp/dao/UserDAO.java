package org.vignesh.capp.dao;

import java.util.List;

import org.vignesh.capp.domain.User;

public interface UserDAO {
	
	public void save(User u);
	public void update(User u);
	public void delete(User u);
	public void delete(Integer userId);
	public User findbyId(Integer userId);
	public List<User> findAll();
	public List<User> findByProperty(String propName, Object propvalue);
	
	
}
