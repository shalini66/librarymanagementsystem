package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.dao.BookDAO;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.factory.BookFactory;

public class BookServiceImp implements BookService{
	private BookDAO dao = BookFactory.getBookDAO();
	public List<BookBean> search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookBean returnBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookBean issueBook(String name, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addBook(BookBean info) {
		
		return dao.addBook(info);
	}

	public boolean delete(String name, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
