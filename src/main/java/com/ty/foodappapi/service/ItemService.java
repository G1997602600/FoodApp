package com.ty.foodappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappapi.dao.ItemDao;
import com.ty.foodappapi.dao.ResponceStructure;
import com.ty.foodappapi.dto.Item;
import com.ty.foodappapi.exceptioncontroller.IdNotFoundException;
import com.ty.foodappapi.repository.Itemrep;

@Service
public class ItemService {
	@Autowired
	ItemDao dao;
	@Autowired
	Itemrep rep;

	public ResponseEntity<ResponceStructure<Item>> SaveItem(Item Item) {
		ResponceStructure<Item> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.CREATED.value());
		responceStructure.setMessage("Object Sucessfully Created");
		responceStructure.setDate(rep.save(Item));
		return new ResponseEntity<ResponceStructure<Item>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<Item>> UpdateItem(Item Item, int id) {
		ResponceStructure<Item> responceStructure = new ResponceStructure();
		Item u = dao.getItem(id);
		if (u != null) {

			u.setName(Item.getName());
			u.setCost(Item.getCost());
			u.setName(Item.getName());
			u.setQuantity(Item.getQuantity());
			responceStructure.setResponcecode(HttpStatus.OK.value());
			responceStructure.setMessage("Welcome to the DataBase");
			responceStructure.setDate(rep.save(u));
			return new ResponseEntity<ResponceStructure<Item>>(responceStructure, HttpStatus.OK);
		}

		else {
			throw new IdNotFoundException("Id you are serching for is not found");
		}

	}

	public ResponseEntity<ResponceStructure<List<Item>>> geAlltItem() {
		List<Item> list = dao.getAll();
		ResponceStructure<List<Item>> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.OK.value());
		responceStructure.setMessage("Welcome to the DataBase");
		responceStructure.setDate(list);
		return new ResponseEntity<ResponceStructure<List<Item>>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<Item>> deleteteItem(int id) {
		ResponceStructure<Item> responceStructure = new ResponceStructure();
		Item u = dao.getItem(id);
		responceStructure.setResponcecode(HttpStatus.OK.value());
		responceStructure.setMessage("Welcome to the DataBase");
		rep.delete(u);
		return new ResponseEntity<ResponceStructure<Item>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<Item>> getItem(int id) {
		ResponceStructure<Item> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.CREATED.value());
		responceStructure.setMessage("Object Sucessfully Created");
		responceStructure.setDate(dao.getItem(id));
		return new ResponseEntity<ResponceStructure<Item>>(responceStructure, HttpStatus.OK);

	}
}
