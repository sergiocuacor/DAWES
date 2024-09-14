package com.sergio.classicmodels.dtos;

public class ClienteDTO {

	
	private String customerName;
	private String phone;
	public ClienteDTO(String customerName, String phone) {
		super();
		this.customerName = customerName;
		this.phone = phone;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ClienteDTO [customerName=" + customerName + ", phone=" + phone + "]";
	}
	
	
	
}
