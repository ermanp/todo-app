package com.huawei.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.IntStream;

@SpringBootTest
class TodoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void encoder_test(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		IntStream.range(0,10).forEach(
				value -> System.out.println(encoder.encode("erman"))
		);
	}

}
