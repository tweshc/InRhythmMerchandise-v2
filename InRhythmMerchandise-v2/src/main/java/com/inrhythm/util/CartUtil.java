package com.inrhythm.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.inrhythm.domain.CheckoutItem;

public class CartUtil {

	public static int isExists(String idString, List<CheckoutItem> cart) {
		int id = Integer.parseInt(idString);
		for(int i=0; i<cart.size(); i++) {
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public static double totalPrice(HttpSession session) {
		List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
		double s = 0;
		for(CheckoutItem item : cart) {
			s += item.getQuantity() * item.getProduct().getPrice().doubleValue();
		}
		return s;
	}
	
}
