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
		user.setAddress("Rua ADM");
		user.setEmail("adm");
		user.setName("adm supremo");
		user.setPassword("123");
		userDao.save(user);
	}

}
