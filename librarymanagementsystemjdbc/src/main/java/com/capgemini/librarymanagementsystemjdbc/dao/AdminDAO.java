package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystemjdbc.dto.AdminBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;

public interface AdminDAO {
	/*
	 * boolean register(AdminBean info); AdminBean auth(String email, String
	 * password);
	 */
	boolean addBook(BookBean book);
	BookBean searchBookTitle(String bname);
	BookBean searchBookAuthor(String bAuthor);
	BookBean searchBookType(int bookType);
	boolean updateBook(BookBean bean);
	boolean removeBook(int bid);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	boolean issueBook(int bid);
}
