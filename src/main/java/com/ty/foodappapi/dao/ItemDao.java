package com.ty.foodappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ty.foodappapi.dto.Item;
import com.ty.foodappapi.repository.Itemrep;

@Repository
public class ItemDao {
	Itemrep repository;

	public Item saveItem(Item Item) {
		return repository.save(Item);
	}

	public Item getItem(int id) {
		Optional<Item> optional = repository.findById(id);
		Item Item = optional.get();
		return Item;
	}

	public List<Item> getAllItem() {
		return repository.findAll();
	}

	public void deleteItem(Item Item) {

		repository.delete(Item);

	}

	public List<Item> getAll() {
		List<Item> Items = repository.findAll();
		return Items;
	}
}
