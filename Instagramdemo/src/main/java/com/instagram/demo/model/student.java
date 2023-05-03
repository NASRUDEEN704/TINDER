package com.instagram.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class student {
	@Id
	private int regno;
	private String name;
	private String department;
	private String email;
	private String blooggrp;
	private String age;
	private String username;
	private String password;
	private String batch;
	private String gender;
	private String mobno;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBlooggrp() {
		return blooggrp;
	}
	public void setBlooggrp(String blooggrp) {
		this.blooggrp = blooggrp;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	student(){}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
