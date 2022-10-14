package com.ty.foodappapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Repository;

import com.ty.foodappapi.dto.User;
import com.ty.foodappapi.repository.UserRep;

import antlr.collections.List;

@Repository
public class UserDao {
	@Autowired
	UserRep rep;

	public User saveUser(User user) {

		return rep.save(user);
	}

	public User validateUser(String email, String password) {

		return rep.findByEmailAndPassword(email, password);
	}

	public User getUser(int id) {
		Optional<User> optional = rep.findById(id);
		User user = optional.get();
		return user;

	}

	public java.util.List<User> getAll() {
		java.util.List<User> list = rep.findAll();
		return list;

	}

}
