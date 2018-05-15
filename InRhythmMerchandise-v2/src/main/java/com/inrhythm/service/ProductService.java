package com.inrhythm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inrhythm.domain.Product;
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
		try {
			id = Integer.parseInt(idString);
		}catch(NumberFormatException e) {
			
		}
		return repo.findById(id);
	}
	
	public Product findByName(String name) {
		return repo.findByName(name);
	}
	
	public List<Product> findByIsElectronic(String isElectronic){
		Boolean boo = false;
		try {
			boo = Boolean.valueOf(isElectronic);
		}catch(Exception e) {
			
		}
		
		return repo.findByIsElectronic(boo);
	}
	
}
