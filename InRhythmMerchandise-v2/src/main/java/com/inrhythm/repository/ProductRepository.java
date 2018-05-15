package com.inrhythm.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.inrhythm.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public Optional<Product> findById(Integer id);
	public Product findByName(String name);
	
	@Query(value = "FROM Product WHERE isElectronic = :isElectronic")
	public List<Product> findByIsElectronic(@Param("isElectronic") Boolean isElectronic);
	
}
