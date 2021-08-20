package com.glt.spring.path;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(exclude = {DataSourceAutoConfiguration.class })
class SpringbootPathlockApplicationTests {

	@Test
	void contextLoads() {
	}

}
