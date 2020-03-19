package com.capgemini.librarymanagement.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.StudentBean;

public interface StudentService {
	boolean register(StudentBean info);
	StudentBean auth(String email, String password);
	LinkedList<BookBean> searchBookTitle(String bname);
	LinkedList<BookBean> searchBookAuthor(String bAuthor);
	LinkedList<BookBean> searchBookType(int bookType);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	boolean requestBook(int bid, String author);
	boolean returnBook(int bid);
}
