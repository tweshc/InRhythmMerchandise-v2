package com.inrhythm.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrhythm.domain.Product;
import com.inrhythm.repository.ProductRepository;
import com.inrhythm.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private ProductController controller;
	
	@Mock
	private ProductService service;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testFindById_shouldReturnProduct() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Optional<Product> product = Optional.of(new Product(123, "ABC", true, 1.99F));
		
		String jsonInString = mapper.writeValueAsString(product.get());
		
		when(service.findById("123")).thenReturn(product);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findById/123"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(jsonInString));
	}
	
	@Test(expected = NestedServletException.class)
	public void testFindById_shouldThrowException() throws Exception {
		
		when(service.findById("12A")).thenThrow(RuntimeException.class);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findById/12A"))
			.andExpect(MockMvcResultMatchers.status().is5xxServerError());
	}
	
	@Test
	public void testFindByName_shouldReturnProduct() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		Product product = new Product(123, "ABC", true, 1.99F);
		
		String jsonInString = mapper.writeValueAsString(product);
		
		when(service.findByName("ABC")).thenReturn(product);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findByName/ABC"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(jsonInString));
	}
	
	@Test(expected = NestedServletException.class)
	public void testFindByName_shouldThrowException() throws Exception{
		
		when(service.findByName("*^%")).thenThrow(RuntimeException.class);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findByName/*^%"))
			.andExpect(MockMvcResultMatchers.status().is5xxServerError());
	}
	
	@Test
	public void testFindByIsElectronic_shouldReturnProduct() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		Product product = new Product(123, "ABC", true, 1.99F);
		List<Product> resultList = new ArrayList<>();
		resultList.add(product);
		
		String jsonInString = mapper.writeValueAsString(resultList);
		
		when(service.findByIsElectronic("true")).thenReturn(resultList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findByIsElectronic/true"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(jsonInString));
	}
	
	@Test(expected = NestedServletException.class)
	public void testFindByIsElectronic_shouldThrowException() throws Exception{
		
		when(service.findByIsElectronic("true")).thenThrow(RuntimeException.class);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findByIsElectronic/true"))
			.andExpect(MockMvcResultMatchers.status().is5xxServerError());
	}
	
	@Test
	public void testFindAll_shouldReturnProducts() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		Product product = new Product(123, "ABC", true, 1.99F);
		List<Product> resultList = new ArrayList<>();
		resultList.add(product);
		Iterable<Product> ite = resultList;
		
		String jsonInString = mapper.writeValueAsString(ite);
		
		when(service.findAll()).thenReturn(ite);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findAll"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(jsonInString));
	}

}
