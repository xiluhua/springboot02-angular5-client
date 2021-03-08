package com.springBoot.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Customer {

	private Integer id;
	private String lastName;

	private String email;
	private Integer age;
	private Integer gender;
	private Integer addr_id;

	private Date createdTime;
	@DateTimeFormat(iso=ISO.DATE)
	private Date birth;
	
	private Boolean isBoss;

	private Address address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer id) {
		super();
		this.id = id;
	}
	public Customer(String lastName, int age) {
		super();
		this.lastName = lastName;
		this.age = age;
	}
	public Customer(int id, String lastName, int age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	//工具方法. 不需要映射为数据表的一列. 
	public String getInfo(){
		return "lastName: " + lastName + ", email: " + email;
	}

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
	public Integer getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(Integer addr_id) {
		this.addr_id = addr_id;
	}
	public Boolean getIsBoss() {
		return isBoss;
	}
	public void setIsBoss(Boolean isBoss) {
		this.isBoss = isBoss;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
    
    
}
