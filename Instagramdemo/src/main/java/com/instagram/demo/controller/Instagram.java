package com.instagram.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.demo.dao.StudentRepositoty;
import com.instagram.demo.model.student;
import com.instagram.demo.service.InstaService;

@RestController
public class Instagram {

	
	@Autowired
	InstaService is;
	@Autowired
	StudentRepositoty rs;
	
	@GetMapping("/get")
	public List<student>getAll(){
		
		return is.getAll();
	}
	@GetMapping("/get/{id}")
	public student getDetailsById(@PathVariable int id)
	{
		return rs.findById(id).orElse(null);
	}
	@PostMapping("/save")
	public String saveall(@RequestBody student id)
	{
		is.saveall(id);
		return "Id details Saved";
	}
	@DeleteMapping("/delete/{id}")
	public String deletebyId(@PathVariable int id)
	{
		rs.deleteById(id);
		return "id details deleted";
		
	}
	@PutMapping("/put")
	public student putDetailsById(@RequestBody student s)
	{
		return rs.save(s);
	}
	@GetMapping("/sortAppmodel/{field}")
	public List<student> sortAppModel(@PathVariable String field)
	{
		return rs.sortAppModel(field);
	}
	@GetMapping("/pagingstudents/{offset}/{pageSize}")
	public List<student>pagingStudents(@PathVariable int offset,@PathVariable int pageSize)
	{
		return is.pagingStudents(offset,pageSize);
	}
	@GetMapping("/pagingAndSortingStudents/{offset}/{pageSize}/{field}")

	public List<student> pagingAndSortingEmployees(@PathVariable int offset,
			@PathVariable int pageSize,
			@PathVariable String field) 
	{
		return is.pagingAndSortingEmployees(offset, pageSize, field);
	}
	@GetMapping("/fetchStudentsByNamePrefix")
	public List<student> fetchStudentsByNamePrefix(@RequestParam String prefix)
	{
		return is.fetchStudentsByNamePrefix(prefix);
	}
	@GetMapping("/fetchStudentsByNameSuffix")
	public List<student> fetchStudentsByNameSuffix(@RequestParam String suffix)
	{
		return is.fetchStudentsByNameSuffix(suffix);
	}
	@GetMapping("/fetchStudentsByDepartment/{dept}/{name}")
	public List<student> fetchByDepartment(@PathVariable String dept,@PathVariable String name)
	{
		return is.getByDepartment(dept, name);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody student u) {
		System.out.println(u.getUsername());
		return is.checkLogin(u.getUsername(), u.getPassword());
	}
	@GetMapping ("/selectByMail")
	public List<student> fetchStudentByMail(String email)
	{
		return is.fetchStudentByEmail1(email);
	}
}
