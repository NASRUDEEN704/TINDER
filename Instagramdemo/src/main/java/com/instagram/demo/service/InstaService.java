package com.instagram.demo.service;

import java.util.List;						

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.instagram.demo.dao.StudentRepositoty;
import com.instagram.demo.model.student;

@Service
public class InstaService {

	@Autowired
	StudentRepositoty rs;
	
	public List<student> getAll(){
		
		return rs.findAll();
	}
	public student saveall(student id) {
		return rs.save(id);
	}
	public List<student> pagingStudents(int offset, int pageSize) {
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<student>studData= rs.findAll(paging);	
		List<student>studList=studData.getContent();
		return studList;
	}
	public List<student> pagingAndSortingEmployees(int offset,
			int pageSize,String field) {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
			Page<student> stud=rs.findAll(paging);
			return stud.getContent();
		}
	public List<student> fetchStudentsByNamePrefix(String prefix)
	{
		return rs.findByNameStartingWith(prefix);
	}
	public List<student> fetchStudentsByNameSuffix(String suffix)
	{
		return rs.findByNameEndingWith(suffix);
	}

	public List<student> getByDepartment(String dept,String name)
	  {
		  return rs.getStudentsByDepartment(dept, name);
	  }
	public String checkLogin(String username , String password) {
		student user = rs.findByUsername(username);
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
	
	public List<student> fetchStudentByEmail1(String email)
	{
		return rs.fetchStudentByEmail(email);
	}
}
