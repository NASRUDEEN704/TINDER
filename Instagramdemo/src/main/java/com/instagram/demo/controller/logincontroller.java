package com.instagram.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.demo.model.loginmodel;

import com.instagram.demo.service.loginservice;

@RestController
public class logincontroller {
	@Autowired
	loginservice serv;
	@PostMapping("/checklogin")
	public String login(@RequestBody loginmodel u) {
		System.out.println(u.getUsername());
		return serv.checkLogin1(u.getUsername(), u.getPassword());
	}
	@PostMapping("/adduser")
			public loginmodel loginmodel(@RequestBody loginmodel u)
			{
			return serv.saveUser(u);
			}
	@GetMapping("/fetch")
	public List<loginmodel>getAll(){
		
		return serv.showDetails();
	}
}
