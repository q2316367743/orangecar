package com.qsd.orange;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	void contextLoads() {
		String encode = bCryptPasswordEncoder.encode("123456");
		System.out.println(encode);
	}

}
