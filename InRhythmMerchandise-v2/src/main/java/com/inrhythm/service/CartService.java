package com.inrhythm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.inrhythm.domain.CheckoutItem;
import com.inrhythm.domain.Product;
import com.inrhythm.util.CartUtil;

/**
 * The Class CartService.
 */
@Service
public class CartService {
	
	/** The product service. */
	@Autowired
	private ProductService productService;

	/**
	 * Cart index.
	 *
	 * @param idString the id string
	 * @param modelMap the model map
	 * @param session the session
	 */
	public void cartIndex(String idString, HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<CheckoutItem> cart = new ArrayList<CheckoutItem>();
			Optional<Product> opt = productService.findById(idString);
			Product product = new Product();
			if(opt.isPresent()) {
				product = opt.get();
			}
			cart.add(new CheckoutItem(product, 1));
			
			session.setAttribute("cart", cart);
		}else {
			List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
			int index = CartUtil.isExists(idString, cart);
			if(index==-1) {
				Optional<Product> opt = productService.findById(idString);
				Product product = new Product();
				if(opt.isPresent()) {
					product = opt.get();
				}
				cart.add(new CheckoutItem(product, 1));
			}else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}		
	}

	/**
	 * Removes the from cart.
	 *
	 * @param idString the id string
	 * @param session the session
	 */
	public void removeFromCart(String idString, HttpSession session) {
		List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
		int index = CartUtil.isExists(idString, cart);
		cart.remove(index);
		session.setAttribute("Cart", cart);		
	}

	/**
	 * Update cart.
	 *
	 * @param request the request
	 * @param session the session
	 */
	public void updateCart(HttpServletRequest request, HttpSession session) {
		String[] quantities = request.getParameterValues("quantity");
		List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
		for(int i=0; i<cart.size();i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		}
		session.setAttribute("cart", cart);
	}

}
