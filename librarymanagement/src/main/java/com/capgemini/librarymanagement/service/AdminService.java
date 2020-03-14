package com.capgemini.librarymanagement.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;

public interface AdminService {
	boolean register(AdminBean info);
	AdminBean auth(String email, String password);
	boolean addBook(BookBean book);
	LinkedList<BookBean> searchBookTitle(String bTitle);
	LinkedList<BookBean> searchBookAuthor(String bAuthor);
	LinkedList<BookBean> searchBookType(int bookType);
	int updateBook(int bid);
	boolean removeBook(int bid);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	boolean issueBook(int bid);
}
