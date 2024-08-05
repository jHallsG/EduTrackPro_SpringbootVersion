package com.edutrackpro.api;

import com.edutrackpro.customvalidator.PHPhoneValidator;

import jakarta.validation.constraints.NotBlank;

public class Students {
	
	private int id;
	@NotBlank(message="")
	private String name;
	@NotBlank
	private String address;
	@PHPhoneValidator
	private Long phone;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " Phone: " + phone + " Address: " + address;
	}
}
