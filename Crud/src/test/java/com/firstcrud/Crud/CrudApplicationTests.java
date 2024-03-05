package com.firstcrud.Crud;

import com.firstcrud.Crud.model.User;
import com.firstcrud.Crud.model.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudApplicationTests {

	@Autowired
	private UserDAO userDAO;

	@Test
	void contextLoads() {
		User user = new User();
		user.setName("Testando 2");
		user.setPassword("senhadoteste2");
		user.setAddress("Rua Testando 2");
		userDAO.saveUser(user);
	}

}
