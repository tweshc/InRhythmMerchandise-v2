/*
 * 
 */
package com.inrhythm.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inrhythm.domain.Product;

/**
 * The Interface ProductRepository.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	public Optional<Product> findById(Integer id);
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the product
	 */
	public Product findByName(String name);
	
	/**
	 * Find by is electronic.
	 *
	 * @param isElectronic the is electronic
	 * @return the list
	 */
	@Query(value = "FROM Product WHERE isElectronic = :isElectronic")
	public List<Product> findByIsElectronic(@Param("isElectronic") Boolean isElectronic);
	
}
