package com.inrhythm.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inrhythm.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductRepositoryTest {
	
    private static final Integer PRODUCT_ID = 123;
    private static final String PRODUCT_NAME = "Foo";
    private static final Boolean IS_ELECTRONIC = true;
    private static final Float PRICE = 1.99F;
   

	@Mock
	private ProductRepository repository;
	
	@Test
	public void test_findById() {
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		Optional<Product> expectedResult = Optional.of(product);
		
		when(repository.findById(PRODUCT_ID)).thenReturn(expectedResult);
		
		assertEquals(expectedResult, repository.findById(PRODUCT_ID));
	}
	
	@Test
	public void test_findById_notFound() {
		when(repository.findById(PRODUCT_ID)).thenReturn(Optional.empty());
		
		Optional<Product> result = repository.findById(PRODUCT_ID);
		
		assertEquals(result, Optional.empty());
	}
	
	@Test
	public void test_findByName() {
		Product expectedResult = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		
		when(repository.findByName(PRODUCT_NAME)).thenReturn(expectedResult);
		
		assertEquals(expectedResult, repository.findByName(PRODUCT_NAME));
	}
	
	@Test(expected = NullPointerException.class)
	public void test_findByName_notFound() {
		Product product = repository.findByName(PRODUCT_NAME);
		
		product.toString();
		//verify(repository, times(1)).findByName(PRODUCT_NAME).toString();
		//verifyNoMoreInteractions(repository);
	}
	
	@Test
	public void test_findByIsElectronic() {
		Product product = new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE);
		ArrayList<Product> expectedResult = new ArrayList<>();
		expectedResult.add(product);
		
		when(repository.findByIsElectronic(IS_ELECTRONIC)).thenReturn(expectedResult);
		
		assertEquals(expectedResult, repository.findByIsElectronic(IS_ELECTRONIC));
	}

}
