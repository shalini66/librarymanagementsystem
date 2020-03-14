package com.capgemini.librarymanagement.factory;

import com.capgemini.librarymanagement.dao.BookDAO;
import com.capgemini.librarymanagement.dao.BookDAOImp;
import com.capgemini.librarymanagement.service.BookService;
import com.capgemini.librarymanagement.service.BookServiceImp;

public class BookFactory {
	public static BookDAO getBookDAO() {
		return new BookDAOImp();
	}
	public static BookService getBookService() {
		return new BookServiceImp();
	}
}
