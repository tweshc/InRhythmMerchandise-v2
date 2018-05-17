/*
 * 
 */
package com.inrhythm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inrhythm.service.ProductService;

/**
 * The Class WebController.
 */
@Controller
public class WebController {

	/** The service. */
	@Autowired
	private ProductService service;
	
	/**
	 * Index.
	 *
	 * @param modelMap the model map
	 * @return the string
	 */
	@RequestMapping(value = "/product/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", service.findAll());
		return "product/index";
	}
	
	/**
	 * Electronics.
	 *
	 * @param modelMap the model map
	 * @return the string
	 */
	@RequestMapping(value = "/product/index/electronics", method = RequestMethod.GET)
	public String electronics(ModelMap modelMap) {
		modelMap.put("products", service.findByIsElectronic("true"));
		return "product/index";
	}
	
	/**
	 * Household products.
	 *
	 * @param modelMap the model map
	 * @return the string
	 */
	@RequestMapping(value = "/product/index/household", method = RequestMethod.GET)
	public String householdProducts(ModelMap modelMap) {
		modelMap.put("products", service.findByIsElectronic("false"));
		return "product/index";
	}
}
