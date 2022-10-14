package com.ty.foodappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappapi.dao.ProductDao;
import com.ty.foodappapi.dao.ResponceStructure;
import com.ty.foodappapi.dto.Login;
import com.ty.foodappapi.dto.Product;
import com.ty.foodappapi.exceptioncontroller.IdNotFoundException;
import com.ty.foodappapi.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductDao dao;
	@Autowired
	ProductRepository rep;

	public ResponseEntity<ResponceStructure<Product>> SaveProduct(Product Product) {
		ResponceStructure<Product> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.CREATED.value());
		responceStructure.setMessage("Object Sucessfully Created");
		responceStructure.setDate(rep.save(Product));
		return new ResponseEntity<ResponceStructure<Product>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<Product>> UpdateProduct(Product Product, int id) {
		ResponceStructure<Product> responceStructure = new ResponceStructure();
		Product u = dao.getProduct(id);
		if (u != null) {
			u.setName(Product.getName());
			u.setPrice(Product.getPrice());
			u.setOffer(Product.getOffer());
			u.setType(Product.getType());
			responceStructure.setResponcecode(HttpStatus.OK.value());
			responceStructure.setMessage("Welcome to the DataBase");
			responceStructure.setDate(rep.save(u));
			return new ResponseEntity<ResponceStructure<Product>>(responceStructure, HttpStatus.OK);
		}

		else {
			throw new IdNotFoundException("Id you are serching for is not found");
		}

	}

	public ResponseEntity<ResponceStructure<List<Product>>> geAlltProduct() {
		List<Product> list = dao.getAll();
		ResponceStructure<List<Product>> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.OK.value());
		responceStructure.setMessage("Welcome to the DataBase");
		responceStructure.setDate(list);
		return new ResponseEntity<ResponceStructure<List<Product>>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<Product>> deleteteProduct(int id) {
		ResponceStructure<Product> responceStructure = new ResponceStructure();
		Product u = dao.getProduct(id);
		responceStructure.setResponcecode(HttpStatus.OK.value());
		responceStructure.setMessage("Welcome to the DataBase");
		rep.delete(u);
		return new ResponseEntity<ResponceStructure<Product>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<Product>> getProduct(int id) {
		ResponceStructure<Product> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.CREATED.value());
		responceStructure.setMessage("Object Sucessfully Created");
		responceStructure.setDate(dao.getProduct(id));
		return new ResponseEntity<ResponceStructure<Product>>(responceStructure, HttpStatus.OK);

	}
}
