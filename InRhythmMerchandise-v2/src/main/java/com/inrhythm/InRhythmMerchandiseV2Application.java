package com.inrhythm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.inrhythm.domain.Product;
import com.inrhythm.repository.ProductRepository;

@SpringBootApplication
public class InRhythmMerchandiseV2Application {

	public static void main(String[] args) {
		SpringApplication.run(InRhythmMerchandiseV2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			repository.save(new Product(10001,"Macbook Pro", true, 1499.99F));
			repository.save(new Product(10002,"Mac Mini", true, 999.99F));
			repository.save(new Product(10003,"Dell Latitude", true, 1299.99F));
			repository.save(new Product(10004,"Bluetooth Keyboard", true, 29.99F));
			repository.save(new Product(10005,"Amazon Kindle", true, 99.99F));
			repository.save(new Product(10006,"Pack of Ten Notepads", false, 9.99F));
			repository.save(new Product(10007,"Introduction to Java 10 Volume 1", false, 39.99F));
			repository.save(new Product(10008,"Granola Bar", false, .99F));
			repository.save(new Product(10009,"InRhythm T-Shirt", false, 14.99F));
			repository.save(new Product(10010,"Black Darjeeling Tea", false, 19.99F));
		};
	}
}
