package com.capgemini.librarymanagement.dao;

import java.util.LinkedList;

import com.capgemini.librarymanagement.database.DataBase;
import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.exception.AdminException;

public class AdminDAOImp implements AdminDAO {

	public boolean register(AdminBean info) {
		for(AdminBean adminBean : DataBase.admin) {
			if(adminBean.getEmail().equals(info.getEmail())) {
				return false;
			}
		}
		DataBase.admin.add(info);
		return true;

	}

	public AdminBean auth(String email, String password) {
		for(AdminBean bean : DataBase.admin) {
			if(bean.getEmail().equals(email) && bean.getPassword().equals(password)) {
				System.out.println("Login Successful");
				return bean;
			} 
		}
		throw new AdminException("Invalid email and password");

	}

	public boolean delete(BookBean book) {
		for (BookBean bean : DataBase.book) {
			if (bean.getId()==book.getId()) {
				return false;
			}

		}
		DataBase.book.add(book);
		return true;
	}


	public boolean addBook(BookBean book) {
		for (BookBean bean : DataBase.book) {
			if (bean.getId()==book.getId()) {
				return false;
			}
		}
		DataBase.book.add(book);
		return true;
	}

	public LinkedList<BookBean> searchBookTitle(String bname) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			String retrievedBname=retrievedBook.getName();
			if(bname.equals(retrievedBname))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new AdminException("Book not found");
		}
		else
		{
			return searchList;
		}

	}

	public LinkedList<BookBean> searchBookAuthor(String bAuthor) {

		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			String retrievedBAuthor=retrievedBook.getAuthor();
			if(bAuthor.equals(retrievedBAuthor))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new AdminException("Book not found");
		}
		else
		{
			return searchList;
		}		

	}

	public LinkedList<BookBean> searchBookType(int bookType) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedBookType=retrievedBook.getId();
			if(bookType==retrievedBookType)
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new AdminException("Book not found");
		}
		else
		{
			return searchList;
		}		
	}

	public int updateBook(int bid) {
		int status=0;
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedId=retrievedBook.getId();
			if(bid==retrievedId)
			{
				status++;
				break;
			}
		}
		throw new AdminException("Book not updated");


	}

	public boolean removeBook(int bid) {
		boolean status=false;
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedId=retrievedBook.getId();
			if(bid==retrievedId)
			{
				status=true;
				DataBase.book.remove(i);
				break;
			}
		}
		return status;

	}

	public LinkedList<Integer> getBookIds() {
		LinkedList<Integer> idList=new LinkedList<Integer>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedBookId=retrievedBook.getId();
			idList.add(retrievedBookId);
		}
		return idList;
	}

	public LinkedList<BookBean> getBooksInfo() {
		return DataBase.book;
	}

	public boolean issueBook(int bid) {
		for(BookBean bean : DataBase.book) {
			if(bean.getId()==bid) {
				DataBase.book.remove(bid);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}



}	

