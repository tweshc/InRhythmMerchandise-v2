package com.inrhythm.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.inrhythm.domain.CheckoutItem;

/**
 * The Class CartUtil.
 */
public class CartUtil {

	/**
	 * Checks if is exists.
	 *
	 * @param idString the id string
	 * @param cart the cart
	 * @return the int
	 */
	public static int isExists(String idString, List<CheckoutItem> cart) {
		int id = Integer.parseInt(idString);
		for(int i=0; i<cart.size(); i++) {
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Total price.
	 *
	 * @param session the session
	 * @return the double
	 */
	public static double totalPrice(HttpSession session) {
		List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
		double s = 0;
		for(CheckoutItem item : cart) {
			s += item.getQuantity() * item.getProduct().getPrice().doubleValue();
		}
		BigDecimal bd = new BigDecimal(s);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
}
