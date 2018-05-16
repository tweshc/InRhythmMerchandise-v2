package com.inrhythm.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;

import com.inrhythm.domain.*;
import com.inrhythm.service.CartService;
import com.inrhythm.service.ProductService;
import com.inrhythm.util.CartUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CartControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private CartController controller;
	
	@Mock
	private CartService service;
	
	private HttpSession mockHttpSession;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test(expected = NullPointerException.class)
	public void indexTest() throws Exception {
		
		List<CheckoutItem> cart = new ArrayList<CheckoutItem>();

		Product mockProduct = new Product(10010, "Pencil", false, 1.50F);
		CheckoutItem mockCheckOutItem = new CheckoutItem(mockProduct, 1);
		cart.add(mockCheckOutItem);
		
		mockHttpSession.setAttribute("cart", cart);
		
		when(CartUtil.totalPrice(mockHttpSession)).thenReturn(0.0);
		
		mockMvc
		.perform(MockMvcRequestBuilders.get("/cart"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("cart", hasSize(1)));
			
	}

}
