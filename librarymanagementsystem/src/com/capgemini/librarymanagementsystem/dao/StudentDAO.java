package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Student;

public interface StudentDAO {
	boolean register(Student info);
	Student auth(String name, String password);
	List<Book> search(String name);
	boolean updatePassword(String password);
}
