package com.ty.foodappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappapi.dto.User;

public interface UserRep extends JpaRepository<User, Integer> {
	User findByEmailAndPassword(String email, String password);

}
