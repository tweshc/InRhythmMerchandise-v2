package com.inrhythm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.inrhythm.domain.Product;
import com.inrhythm.service.ProductService;

/**
 * The Class ProductController.
 */
@RestController
public class ProductController {
	
	/** The service. */
	@Autowired
	private ProductService service;

	/**
	 * Find by id.
	 *
	 * @param idString the id string
	 * @return the optional
	 */
	@RequestMapping(value = "/findById/{idString}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Product> findById(@PathVariable String idString){
		return service.findById(idString);
	}
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the product
	 */
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET, produces = "application/json")
	public Product findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	/**
	 * Find by is electronic.
	 *
	 * @param isElectronic the is electronic
	 * @return the list
	 */
	@RequestMapping(value = "/findByIsElectronic/{isElectronic}", method = RequestMethod.GET, produces = "application/json")
	public List<Product> findByIsElectronic(@PathVariable String isElectronic){
		return service.findByIsElectronic(isElectronic);
	}
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Product> findAll(){
		return service.findAll();
	}
	
	/**
	 * Delete by id.
	 *
	 * @param idString the id string
	 */
	@RequestMapping(value = "/deleteById/{idString}", method = RequestMethod.GET, produces = "application/json")
	public void deleteById(@PathVariable String idString){
		service.deleteById(idString);
	}
	
}
