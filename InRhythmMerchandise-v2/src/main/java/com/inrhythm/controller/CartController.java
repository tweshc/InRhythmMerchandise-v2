/*
 * 
 */
package com.inrhythm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inrhythm.service.CartService;
import com.inrhythm.util.CartUtil;

/**
 * The Class CartController.
 */
@Controller
@RequestMapping("cart")
public class CartController {
	
	/** The cart service. */
	@Autowired
	private CartService cartService;
	
	/**
	 * Index.
	 *
	 * @param modelMap the model map
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		
		modelMap.put("total", CartUtil.totalPrice(session));
		
		return "cart/index";
	}
	
	/**
	 * Cart index.
	 *
	 * @param idString the id string
	 * @param modelMap the model map
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String cartIndex(@PathVariable("id") String idString, ModelMap modelMap, HttpSession session) {
		
		cartService.cartIndex(idString, modelMap, session);
		
		return "redirect:../../cart";
	}
	
	/**
	 * Removes the from cart.
	 *
	 * @param idString the id string
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value="remove/{id}", method = RequestMethod.GET)
	public String removeFromCart(@PathVariable("id") String idString, HttpSession session) {
		
		cartService.removeFromCart(idString, session);
		
		return "redirect:../../cart";
	}
	
	/**
	 * Update cart.
	 *
	 * @param request the request
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String updateCart(HttpServletRequest request, HttpSession session) {
		
		cartService.updateCart(request, session);
		
		return "redirect:../cart";
	}
	
}
