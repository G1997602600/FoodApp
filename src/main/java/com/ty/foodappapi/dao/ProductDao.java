package com.ty.foodappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Repository;

import com.ty.foodappapi.dto.Product;
import com.ty.foodappapi.repository.ProductRepository;
@Repository
public class ProductDao {
	ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public Product getProduct(int id) {
		Optional<Product> optional = repository.findById(id);
		Product product = optional.get();
		return product;
	}

	public List<Product> getAllProduct() {
		return repository.findAll();
	}

	public void deleteProduct(Product product) {

		repository.delete(product);

	}

	public List<Product> getAll() {
		List<Product> products = repository.findAll();
		return products;
	}

}
