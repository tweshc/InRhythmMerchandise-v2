package com.inrhythm.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrhythm.domain.Product;
import com.inrhythm.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class WebControllerTest {
	
	private MockMvc mockMvc;

	@InjectMocks
	private WebController controller;
	
	@Mock
	private ProductService service;

	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testIndex_ShouldReturnView() throws Exception{
		Product product = new Product(123, "ABC", true, 1.99F);
		List<Product> resultList = new ArrayList<>();
		resultList.add(product);
		Iterable<Product> ite = resultList;
		
		when(service.findAll()).thenReturn(ite);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/product/index"))
			.andExpect(status().isOk())
			.andExpect(view().name("product/index"));
	}
	
	@Test
	public void testElectronics_ShouldReturnView() throws Exception{
		Product product = new Product(123, "ABC", true, 1.99F);
		List<Product> resultList = new ArrayList<>();
		resultList.add(product);
		
		when(service.findByIsElectronic("true")).thenReturn(resultList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/product/index/electronics"))
			.andExpect(status().isOk())
			.andExpect(view().name("product/index"));
	}
	
	@Test
	public void testHouseholdProducts_ShouldReturnView() throws Exception{
		Product product = new Product(123, "ABC", false, 1.99F);
		List<Product> resultList = new ArrayList<>();
		resultList.add(product);
		
		when(service.findByIsElectronic("false")).thenReturn(resultList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/product/index/household"))
			.andExpect(status().isOk())
			.andExpect(view().name("product/index"));
	}

}
