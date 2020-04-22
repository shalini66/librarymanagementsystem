package com.capgemini.librarymanagement.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.dao.StudentDAO;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.factory.StudentFactory;

public class StudentServiceImp implements StudentService {
	private StudentDAO dao = StudentFactory.getStudentDAO();
	public boolean register(StudentBean info) {
		return dao.register(info) ;
	}

	public StudentBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	public LinkedList<BookBean> searchBookByTitle(String bookName) {                                                         
		return dao.searchBookByTitle(bookName);                                                                              
	}                                                                                                                   
                                                                                                                        
	public LinkedList<BookBean> searchBookByAuthor(String bookAuthor) {                                                      
		return dao.searchBookByAuthor(bookAuthor);                                                                           
	}                                                                                                                   
                                                                                                                        
	public LinkedList<BookBean> searchBookByCategory(String bookCategory) {                                                       
		return dao.searchBookByCategory(bookCategory);                                                                            
	}                                                                                                                   
                                                                                                                        
	public LinkedList<Integer> getBookIds() {                                                                           
		return dao.getBookIds();                                                                                        
	}                                                                                                                   
                                                                                                                        
	public LinkedList<BookBean> getBooksInfo() {                                                                        
		return dao.getBooksInfo();                                                                                      
	}

	public RequestBean bookRequest(StudentBean student, BookBean book) {
		
		return dao.bookRequest(student, book);
	}

	public RequestBean bookReturn(StudentBean student, BookBean book) {
		
		return dao.bookReturn(student, book);
	}                                     
}
