package org.vignesh.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.vignesh.capp.config.SpringRootConfig;
import org.vignesh.capp.dao.UserDAO;
import org.vignesh.capp.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		User u=new User();
		u.setUserId(1);
		u.setName("viggnesh");
		u.setPhone("555-666-7770");
		u.setEmail("viggnesh@viggnesh.org");
		u.setRole(1);
		u.setLoginStaus(1);
		userDAO.update(u);
		System.out.println("-----Data Updated--------");
	}

}
