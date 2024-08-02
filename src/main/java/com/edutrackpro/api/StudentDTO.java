package com.edutrackpro.api;

public class StudentDTO {
	
	private String name, address;
	private Long phone;
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	} 
	public Long getPhone() {
		return phone;
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
		return ("Name: " + name + ", Phone: " + phone + ", Address" + address);
	}
}
