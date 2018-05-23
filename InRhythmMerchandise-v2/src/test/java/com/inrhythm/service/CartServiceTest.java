package com.inrhythm.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inrhythm.domain.CheckoutItem;
import com.inrhythm.domain.Product;
import com.inrhythm.util.CartUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class CartServiceTest {
	
    private static final Integer PRODUCT_ID = 123;
    private static final String PRODUCT_ID_STR = "123";
    private static final String PRODUCT_NAME = "Foo";
    private static final Boolean IS_ELECTRONIC = true;
    private static final Float PRICE = 1.99F;
    private static final String CART = "cart";

	protected MockHttpSession session;
	protected MockHttpServletRequest request;
	
	@InjectMocks
	private CartService service;
	
	@Mock
	private ProductService prodService;
	
	protected void startSession() {
		session = new MockHttpSession();
	}
	
	protected void endSession() {
		session.clearAttributes();
		session = null;
	}

	@Test
	public void test_cartIndex_Positive() {
		startSession();
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		Optional<Product> expectedResult = Optional.of(product);
		when(prodService.findById(PRODUCT_NAME)).thenReturn(expectedResult);
		
		service.cartIndex(String.valueOf(PRODUCT_ID), session);
		
		assertTrue(session.getAttribute(CART) != null);
		endSession();
	}
	
	@Test 
	public void test_cartIndex_Negative() {
		startSession();
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		Optional<Product> expectedResult = Optional.of(product);
		when(prodService.findById(PRODUCT_ID_STR)).thenReturn(expectedResult);
		
		List<CheckoutItem> cart = new ArrayList<>();
		Product product2 = prodService.findById(PRODUCT_ID_STR).get();
		cart.add(new CheckoutItem(product2, 1));
		
		session.setAttribute(CART, cart);
		
		service.cartIndex(PRODUCT_ID_STR, session);
		
		ArrayList<CheckoutItem> sessionCart = (ArrayList<CheckoutItem>) session.getAttribute(CART);
		
		assertEquals(cart, sessionCart);
		assertTrue(sessionCart!=null);
		endSession();
	}
	
	@Test
	public void test_removeFromCart() {
		startSession();
		
		List<CheckoutItem> cart = new ArrayList<>();
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		cart.add(new CheckoutItem(product, 1));
		
		session.setAttribute(CART, cart);
		
		service.removeFromCart(PRODUCT_ID_STR, session);
		List<CheckoutItem> sessionCart = (List<CheckoutItem>) session.getAttribute(CART);
		assertTrue(sessionCart.size()==0);
		endSession();
	}
	
	@Test
	public void test_updateCart() {
		startSession();
		request = new MockHttpServletRequest();
		request.setParameter("quantity", "1");
		List<CheckoutItem> cart = new ArrayList<>();
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		cart.add(new CheckoutItem(product, 1));
		
		session.setAttribute(CART, cart);
		
		service.updateCart(request, session);
		
		List<CheckoutItem> sessionCart = (List<CheckoutItem>) session.getAttribute(CART);
		CheckoutItem item = sessionCart.get(0);
		assertTrue(item.getQuantity() == 1);
		
		endSession();
	}

	
}
