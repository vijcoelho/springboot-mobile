package com.teste.tcc;

import com.teste.tcc.model.user.User;
import com.teste.tcc.model.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TccApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	void contextLoad() {
		User user = new User();
		user.setAddress("Pc da escola");
		user.setEmail("escola@email.com");
		user.setName("escola");
		user.setPassword("123");
		userDao.save(user);
	}

}
