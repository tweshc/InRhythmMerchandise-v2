package com.inrhythm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.inrhythm.domain.Product;
import com.inrhythm.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Product> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value = "/findById/{idString}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Product> findById(@PathVariable String idString){
		return service.findById(idString);
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET, produces = "application/json")
	public Product findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@RequestMapping(value = "/findByIsElectronic/{isElectronic}", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Product> findByIsElectronic(@PathVariable String isElectronic){
		return service.findByIsElectronic(isElectronic);
	}
	
}
