package com.ty.foodappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappapi.dao.FoodOrderDao;
import com.ty.foodappapi.dao.ResponceStructure;
import com.ty.foodappapi.dto.FoodOrder;
import com.ty.foodappapi.dto.Item;
import com.ty.foodappapi.exceptioncontroller.IdNotFoundException;

@Service
public class FoodService {
	@Autowired
	FoodOrderDao dao;

	public ResponseEntity<ResponceStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		double price = 0;
		List<Item> items = foodOrder.getItems();
		for (Item item : items) {
			price = price + item.getCost() * item.getQuantity();
			item.setFoodOrder(foodOrder);
		}
		foodOrder.setCost(price);
		ResponceStructure<FoodOrder> responseStructure = new ResponceStructure<FoodOrder>();
		responseStructure.setResponcecode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setDate(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponceStructure<FoodOrder>> getFoodOrder(int id) {
		Optional<FoodOrder> optional = dao.getFoodOrder(id);
		ResponceStructure<FoodOrder> responseStructure = new ResponceStructure<FoodOrder>();
		if (optional.isPresent()) {
			responseStructure.setResponcecode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setDate(optional.get());
			return new ResponseEntity<ResponceStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id " + id + ", is exist");
		}
	}
}
