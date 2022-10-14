package com.ty.foodappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappapi.dao.ResponceStructure;
import com.ty.foodappapi.dto.FoodOrder;
import com.ty.foodappapi.service.FoodService;

@RestController
public class FodOrderController {
	@Autowired
	FoodService services;

	@PostMapping("/foodorders")
	public ResponseEntity<ResponceStructure<FoodOrder>> saveProduct(@RequestBody FoodOrder foodOrder) {
		return services.saveFoodOrder(foodOrder);
	}

	@PostMapping("/foodorders/{id}")
	public ResponseEntity<ResponceStructure<FoodOrder>> getFoodOrder(@PathVariable int id) {
		return services.getFoodOrder(id);
	}
}
