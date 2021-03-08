package com.springBoot.entity;

public class Address {

	private Integer id;
	private String city;
	private String road;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(Integer id) {
		super();
		this.id = id;
	}
	public Address(Integer id, String city) {
		super();
		this.id   = id;
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
    
    
}
