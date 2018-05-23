package com.inrhythm.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inrhythm.domain.CheckoutItem;
import com.inrhythm.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
public class CartUtilTest {
	
	private static final Integer PRODUCT_ID = 123;
	private static final String PRODUCT_ID_STR = "123";
    private static final String PRODUCT_NAME = "Foo";
    private static final Boolean IS_ELECTRONIC = true;
    private static final Float PRICE = 1.99F;
    private static final String CART = "cart";
    
    protected MockHttpSession session;

	@Test
	public void test_isExists() {
		List<CheckoutItem> cart = new ArrayList<>();
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		CheckoutItem item = new CheckoutItem(product, 1);
		cart.add(item);
		
		assertTrue(CartUtil.isExists(PRODUCT_ID_STR, cart) == 0);
	}
	
	@Test
	public void test_isExists_returnsNotFoundCode() {
		List<CheckoutItem> cart = new ArrayList<>();
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		CheckoutItem item = new CheckoutItem(product, 1);
		cart.add(item);
		
		assertTrue(CartUtil.isExists(PRODUCT_ID_STR + 1, cart) == -1);
	}
	
	@Test
	public void test_totalPrice() {
		session = new MockHttpSession();
		List<CheckoutItem> cart = new ArrayList<>();
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		CheckoutItem item = new CheckoutItem(product, 5);
		cart.add(item);
		session.setAttribute(CART, cart);
		
		ArrayList<CheckoutItem> sessionCart = (ArrayList<CheckoutItem>) session.getAttribute(CART);
		assertTrue(9.95 == CartUtil.totalPrice(session));
	}

}
