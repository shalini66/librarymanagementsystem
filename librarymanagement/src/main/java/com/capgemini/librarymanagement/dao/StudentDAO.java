package com.capgemini.librarymanagement.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;

public interface StudentDAO {
	boolean register(StudentBean info);
	StudentBean auth(String email, String password);
	LinkedList<BookBean> searchBookByTitle(String bookName);
	LinkedList<BookBean> searchBookByAuthor(String bookAuthor);
	LinkedList<BookBean> searchBookByCategory(String Category);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	public RequestBean bookRequest(StudentBean student, BookBean book);
	public RequestBean bookReturn(StudentBean student, BookBean book);
}
