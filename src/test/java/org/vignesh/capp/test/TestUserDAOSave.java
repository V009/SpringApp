package org.vignesh.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.vignesh.capp.config.SpringRootConfig;
import org.vignesh.capp.dao.UserDAO;
import org.vignesh.capp.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		User u=new User();
		u.setName("amar");
		u.setPhone("555-666-7771");
		u.setEmail("amar@amar.org");
		u.setAddress("India");
		u.setLoginName("amar");
		u.setPassword("amar");
		u.setRole(1);
		u.setLoginStaus(1);
		
		userDAO.save(u);
		System.out.println("-----Data Saved--------");
		
		
	}
}
