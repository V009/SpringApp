package org.vignesh.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.vignesh.capp.config.SpringRootConfig;
import org.vignesh.capp.dao.UserDAO;
import org.vignesh.capp.domain.User;

public class TestUserDAOFindSingleRecord {
	
	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		User u =userDAO.findbyId(2);
		System.out.println("------------User Detail------------");
		System.out.println(u.getUserId());
		System.out.println(u.getName());
		System.out.println(u.getPhone());
		System.out.println(u.getEmail());
		System.out.println(u.getAddress());
		System.out.println(u.getLoginName());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getRole());

	}
}
