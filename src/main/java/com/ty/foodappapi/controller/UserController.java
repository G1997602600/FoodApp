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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappapi.dao.ResponceStructure;
import com.ty.foodappapi.dto.Login;
import com.ty.foodappapi.dto.User;
import com.ty.foodappapi.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/users")
	public ResponseEntity<ResponceStructure<User>> saveUser(@RequestBody User user) {

		return service.SaveUser(user);
	}

	@PostMapping("/users/validate")
	public ResponseEntity<ResponceStructure<User>> validateUser(@RequestBody Login login) {
		return service.validateUser(login);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponceStructure<User>> deleteUser(@PathVariable int id) {
		return service.deleteteUser(id);

	}

	@GetMapping("/users")
	public ResponseEntity<ResponceStructure<List<User>>> getAll() {
		return service.geAlltUser();

	}

	@PutMapping("/users")
	public ResponseEntity<ResponceStructure<User>> updateUser(@RequestBody User user, @PathVariable int id) {
		return service.UpdateUser(user, id);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<ResponceStructure<User>> getUser(@PathVariable int id) {
		return service.getUser(id);
	}
}
