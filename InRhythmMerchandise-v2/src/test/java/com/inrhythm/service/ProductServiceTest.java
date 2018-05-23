package com.inrhythm.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.inrhythm.domain.Product;
import com.inrhythm.repository.ProductRepository;

public class ProductServiceTest {

    private static final Integer PRODUCT_ID = 123;
    private static final String PRODUCT_ID_STR = "123";
    private static final String PRODUCT_NAME = "Foo";
    private static final Boolean IS_ELECTRONIC = true;
    private static final Float PRICE = 1.99F;
   
    @Mock
	private ProductRepository repository;
    @InjectMocks
	private ProductService service;
	
//	@Test
//	public void test_findAll() {
//		//service = new ProductService();
//		List<Product> list = new ArrayList<>();
//		list.add(new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE));
//		//Iterable<Product> ite = list;
//		repository = mock(ProductRepository.class);
//		service.setRepo(repository);
//		
//		when(repository.findAll()).thenReturn(list);
//		
//		assertNotNull(service.findAll());
//	}
    
    @Test
    public void test_findById() {
//		
//		Optional<Product> opt = Optional.of(new Product(PRODUCT_ID, PRODUCT_NAME, IS_ELECTRONIC, PRICE));
//		when(service.findById(PRODUCT_ID_STR)).thenReturn(opt);
    }
}
