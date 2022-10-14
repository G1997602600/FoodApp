package com.ty.foodappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.foodappapi.dao.ResponceStructure;
import com.ty.foodappapi.dao.UserDao;
import com.ty.foodappapi.dto.Item;
import com.ty.foodappapi.dto.Login;
import com.ty.foodappapi.dto.User;
import com.ty.foodappapi.exceptioncontroller.IdNotFoundException;
import com.ty.foodappapi.repository.UserRep;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	@Autowired
	UserRep rep;

	public ResponseEntity<ResponceStructure<User>> SaveUser(User user) {
		ResponceStructure<User> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.CREATED.value());
		responceStructure.setMessage("Object Sucessfully Created");
		responceStructure.setDate(rep.save(user));
		return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<User>> validateUser(Login login) {
		ResponceStructure<User> responceStructure = new ResponceStructure();
		User user = dao.validateUser(login.getEmail(), login.getPassword());
		if (user != null) {
			responceStructure.setResponcecode(HttpStatus.OK.value());
			responceStructure.setMessage("Deleted from  the DataBase");
			responceStructure.setDate(user);
		} else {
			responceStructure.setResponcecode(HttpStatus.NOT_FOUND.value());
			responceStructure.setMessage("Invalid Credentials");
		}

		return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponceStructure<User>> UpdateUser(User user, int id) {
		ResponceStructure<User> responceStructure = new ResponceStructure();
		User u = dao.getUser(id);
		if (u != null) {

			u.setName(user.getName());
			u.setRole(user.getRole());
			u.setName(user.getName());
			u.setPhone(user.getPhone());
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			responceStructure.setResponcecode(HttpStatus.OK.value());
			responceStructure.setMessage("Welcome to the DataBase");
			responceStructure.setDate(rep.save(u));
			return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.OK);
		}

		else {
			throw new IdNotFoundException("Id you are serching for is not found");
		}

	}

	public ResponseEntity<ResponceStructure<List<User>>> geAlltUser() {
		List<User> list = dao.getAll();
		ResponceStructure<List<User>> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.OK.value());
		responceStructure.setMessage("Welcome to the DataBase");
		responceStructure.setDate(list);
		return new ResponseEntity<ResponceStructure<List<User>>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<User>> deleteteUser(int id) {
		ResponceStructure<User> responceStructure = new ResponceStructure();
		User u = dao.getUser(id);
		responceStructure.setResponcecode(HttpStatus.OK.value());
		responceStructure.setMessage("Welcome to the DataBase");
		rep.delete(u);
		return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponceStructure<User>> getUser(int id) {
		ResponceStructure<User> responceStructure = new ResponceStructure();
		responceStructure.setResponcecode(HttpStatus.CREATED.value());
		responceStructure.setMessage("Object Sucessfully Created");
		responceStructure.setDate(dao.getUser(id));
		return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.OK);

	}
}
