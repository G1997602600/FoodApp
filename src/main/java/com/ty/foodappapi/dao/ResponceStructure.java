package com.ty.foodappapi.dao;

public class ResponceStructure<T> {
	int responcecode;
	String message;
	T data;

	public int getResponcecode() {
		return responcecode;
	}

	public void setResponcecode(int responcecode) {
		this.responcecode = responcecode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getDate() {
		return data;
	}

	public void setDate(T date) {
		this.data = date;
	}

}
