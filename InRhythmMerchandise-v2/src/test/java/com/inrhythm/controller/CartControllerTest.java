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
	
	private static final Integer PRODUCT_ID = 123;
    private static final String PRODUCT_NAME = "Foo";
    private static final Boolean IS_ELECTRONIC = true;
    private static final Float PRICE = 1.99F;
    private static final String CART = "cart";

	private MockMvc mockMvc;
	private HttpSession mockHttpSession;

	@InjectMocks
	private ProductController controller;
	
	@Mock
	private ProductService service;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test(expected = NullPointerException.class)
	public void indexTest() throws Exception {
		
		List<CheckoutItem> cart = new ArrayList<CheckoutItem>();

		Product mockProduct = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		CheckoutItem mockCheckOutItem = new CheckoutItem(mockProduct, 1);
		cart.add(mockCheckOutItem);
		
		mockHttpSession.setAttribute(CART, cart);
		
		when(CartUtil.totalPrice(mockHttpSession)).thenReturn(0.0);
		
		mockMvc
		.perform(MockMvcRequestBuilders.get("/cart"))
			.andExpect(status().isOk())
			.andExpect(model().attribute(CART, hasSize(1)));
			
	}

}
