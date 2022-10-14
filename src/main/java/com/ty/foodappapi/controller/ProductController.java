package com.ty.foodappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappapi.dao.ResponceStructure;
import com.ty.foodappapi.dto.Login;
import com.ty.foodappapi.dto.Product;
import com.ty.foodappapi.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;

	@PostMapping("/Products")
	public ResponseEntity<ResponceStructure<Product>> saveProduct(@RequestBody Product Product) {

		return service.SaveProduct(Product);
	}

	@DeleteMapping("/Products/{id}")
	public ResponseEntity<ResponceStructure<Product>> deleteProduct(@PathVariable int id) {
		return service.deleteteProduct(id);

	}

	@GetMapping("/Products")
	public ResponseEntity<ResponceStructure<List<Product>>> getAll() {
		return service.geAlltProduct();

	}

	@PutMapping("/Products")
	public ResponseEntity<ResponceStructure<Product>> updateProduct(@RequestBody Product Product,
			@PathVariable int id) {
		return service.UpdateProduct(Product, id);
	}

	@GetMapping("/Products/{id}")
	public ResponseEntity<ResponceStructure<Product>> getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}
}
