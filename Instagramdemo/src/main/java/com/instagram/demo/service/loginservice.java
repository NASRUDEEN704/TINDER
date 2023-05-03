package com.instagram.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.demo.dao.loginrepository;
import com.instagram.demo.model.loginmodel;


@Service
public class loginservice {
	@Autowired
	loginrepository rep;
	public loginmodel saveUser(loginmodel u) {
		return rep.save(u);
	}
	public List<loginmodel> showDetails(){
		return rep.findAll();
	}
	public String checkLogin1(String username , String password) {
		loginmodel user = rep.findByUsername(username);
		if(user==null) {
			return "no user found";
		}
		else {
			if(user.getPassword().equals(password)) {
				return "login succesfull";
			}else {
				return "login failed";
			}
		}
	}

}
