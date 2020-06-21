package com.nextbook.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CatalogApplicationTests {

	private static final String FIRST_TEST_MESSAGE = "My first test";

	@Test
	void contextLoads() {
		final String aTest = "My first test";

		assertEquals(aTest, FIRST_TEST_MESSAGE);
	}

}
