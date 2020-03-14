package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Student;

public class StudentDAOImp implements StudentDAO {

	@Override
	public boolean register(Student info) {
		Student user = new Student();
		user.setName(info.getName());
		user.setId(info.getId());
		user.setEmail(info.getEmail());
		user.setMobile(info.getMobile());
		user.setDepartment(info.getDepartment());
		
		return false;
	}

	@Override
	public Student auth(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
