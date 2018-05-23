package com.inrhythm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inrhythm.domain.Product;
import com.inrhythm.exception.IncorrectInputException;
import com.inrhythm.repository.ProductRepository;

/**
 * The Class ProductService.
 */
@Service
public class ProductService {

	/** The repo. */
	@Autowired
	ProductRepository repo;
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	public Iterable<Product> findAll(){
		return repo.findAll();
	}
	
	/**
	 * Find by id.
	 *
	 * @param idString the id string
	 * @return the optional
	 */
	public Optional<Product> findById(String idString) {
		Integer id = 0;
		id = Integer.parseInt(idString);
		Optional<Product> result = repo.findById(id);
		
		if(result.isPresent()) {
			return result;
		}else {
			throw new IncorrectInputException("No PRODUCT in db found for id: " + idString);
		}
	}
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the product
	 */
	public Product findByName(String name) {
		Product result = repo.findByName(name);
		if(result!=null && result.getName().equalsIgnoreCase(name)) {
			return repo.findByName(name);
		}else {
			throw new IncorrectInputException("No PRODUCT in db found for name: " + name);
		}
	}
	
	/**
	 * Find by is electronic.
	 *
	 * @param isElectronic the is electronic
	 * @return the list
	 */
	public List<Product> findByIsElectronic(String isElectronic){
		if(isElectronic.equalsIgnoreCase("true") || isElectronic.equalsIgnoreCase("false")) {
			return repo.findByIsElectronic(Boolean.valueOf(isElectronic));
		}else {
			throw new IncorrectInputException("Expecting in parameter \"true\" or \"false\" but got: " + isElectronic);
		}
	}

	/**
	 * Delete by id.
	 *
	 * @param idString the id string
	 */
	public void deleteById(String idString) {
		Integer id = Integer.valueOf(idString);
		repo.deleteById(id);
	}
	
	public void setRepo(ProductRepository repo) {
		this.repo = repo;
	}
	
}
