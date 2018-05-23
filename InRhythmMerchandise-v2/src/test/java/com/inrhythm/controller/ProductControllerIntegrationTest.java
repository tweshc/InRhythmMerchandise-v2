package com.inrhythm.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void createClient() {
		ResponseEntity<Optional> response = restTemplate.getForEntity("/findById/10010", Optional.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().get() != null);
	}

}
