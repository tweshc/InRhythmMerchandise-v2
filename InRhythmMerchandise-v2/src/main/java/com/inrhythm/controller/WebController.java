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
	
}
