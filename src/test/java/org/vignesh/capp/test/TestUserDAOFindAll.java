package org.vignesh.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.vignesh.capp.config.SpringRootConfig;
import org.vignesh.capp.dao.UserDAO;
import org.vignesh.capp.domain.User;

public class TestUserDAOFindAll {
	
	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		List<User> users =userDAO.findAll();
		
		System.out.println("------------User Detail------------");
		for(User u:users) 
		{	
			
		System.out.println(u.getUserId());
		System.out.println(u.getName());
		System.out.println(u.getPhone());
		System.out.println(u.getEmail());
		System.out.println(u.getAddress());
		System.out.println(u.getLoginName());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getRole());

		System.out.println("------------------------");
		}
	}
}
