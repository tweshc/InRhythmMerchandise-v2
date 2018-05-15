package com.inrhythm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inrhythm.service.ProductService;

@Controller
public class WebController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/product/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", service.findAll());
		return "product/index";
	}
	
	@RequestMapping(value = "/product/index/electronics", method = RequestMethod.GET)
	public String electronics(ModelMap modelMap) {
		modelMap.put("products", service.findByIsElectronic("true"));
		System.out.println(service.findByIsElectronic("true"));
		return "product/index";
	}
	
	@RequestMapping(value = "/product/index/household", method = RequestMethod.GET)
	public String householdProducts(ModelMap modelMap) {
		modelMap.put("products", service.findByIsElectronic("false"));
		System.out.println(service.findByIsElectronic("false"));
		return "product/index";
	}
}
