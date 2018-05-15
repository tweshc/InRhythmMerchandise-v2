package com.inrhythm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inrhythm.domain.CheckoutItem;
import com.inrhythm.domain.Product;
import com.inrhythm.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		modelMap.put("total", totalPrice(session));
		return "cart/index";
	}
	
	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String index(@PathVariable("id") String idString, ModelMap modelMap, HttpSession session) {
		
		if(session.getAttribute("cart") == null) {
			List<CheckoutItem> cart = new ArrayList<CheckoutItem>();
			Optional<Product> opt = service.findById(idString);
			Product product = new Product();
			if(opt.isPresent()) {
				product = opt.get();
			}
			cart.add(new CheckoutItem(product, 1));
			
			session.setAttribute("cart", cart);
		}else {
			List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
			int index = isExists(idString, cart);
			if(index==-1) {
				Optional<Product> opt = service.findById(idString);
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
		
		return "redirect:../../cart";
	}
	
	@RequestMapping(value="remove/{id}", method = RequestMethod.GET)
	public String removeFromCart(@PathVariable("id") String idString, HttpSession session) {
		List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
		int index = isExists(idString, cart);
		cart.remove(index);
		session.setAttribute("Cart", cart);
		return "redirect:../../cart";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String updateCart(HttpServletRequest request, HttpSession session) {
		String[] quantities = request.getParameterValues("quantity");
		List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
		for(int i=0; i<cart.size();i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		}
		session.setAttribute("cart", cart);
		return "redirect:../cart";
	}
	
	private int isExists(String idString, List<CheckoutItem> cart) {
		int id = Integer.parseInt(idString);
		for(int i=0; i<cart.size(); i++) {
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	private double totalPrice(HttpSession session) {
		List<CheckoutItem> cart = (List<CheckoutItem>) session.getAttribute("cart");
		double s = 0;
		for(CheckoutItem item : cart) {
			s += item.getQuantity() * item.getProduct().getPrice().doubleValue();
		}
		return s;
	}
	
	
}
