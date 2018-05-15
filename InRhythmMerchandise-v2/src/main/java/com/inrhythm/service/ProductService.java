package com.inrhythm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inrhythm.domain.Product;
import com.inrhythm.exception.IncorrectInputException;
import com.inrhythm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	public Iterable<Product> findAll(){
		return repo.findAll();
	}
	
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
	
	public Product findByName(String name) {
		Product result = repo.findByName(name);
		if(result!=null && result.getName().equalsIgnoreCase(name)) {
			return repo.findByName(name);
		}else {
			throw new IncorrectInputException("No PRODUCT in db found for name: " + name);
		}
	}
	
	public List<Product> findByIsElectronic(String isElectronic){
		if(isElectronic.equalsIgnoreCase("true") || isElectronic.equalsIgnoreCase("false")) {
			return repo.findByIsElectronic(Boolean.valueOf(isElectronic));
		}else {
			throw new IncorrectInputException("Expecting in parameter \"true\" or \"false\" but got: " + isElectronic);
		}
	}
	
}
