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
import com.inrhythm.service.CartService;
import com.inrhythm.service.ProductService;
import com.inrhythm.util.CartUtil;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		
		modelMap.put("total", CartUtil.totalPrice(session));
		
		return "cart/index";
	}
	
	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String cartIndex(@PathVariable("id") String idString, ModelMap modelMap, HttpSession session) {
		
		cartService.cartIndex(idString, modelMap, session);
		
		return "redirect:../../cart";
	}
	
	@RequestMapping(value="remove/{id}", method = RequestMethod.GET)
	public String removeFromCart(@PathVariable("id") String idString, HttpSession session) {
		
		cartService.removeFromCart(idString, session);
		
		return "redirect:../../cart";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String updateCart(HttpServletRequest request, HttpSession session) {
		
		cartService.updateCart(request, session);
		
		return "redirect:../cart";
	}
	
}
