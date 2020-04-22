package com.capgemini.librarymanagement.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;

public interface AdminDAO {
	boolean register(AdminBean info);
	AdminBean login(String email, String password);
	boolean addBook(BookBean book);
	LinkedList<BookBean> searchBookByTitle(String bookName);
	LinkedList<BookBean> searchBookByAuthor(String bookAuthor);
	LinkedList<BookBean> searchBookByCategory(String bookCategory);
	boolean updateBook(BookBean book);
	boolean removeBook(int bookId);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	List<StudentBean> showUsers();
	List<RequestBean> showRequests();
	boolean bookIssue(StudentBean student,BookBean book);
	boolean isBookReceived(StudentBean student,BookBean book);
}
