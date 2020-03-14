package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.database.DataBase;
import com.capgemini.librarymanagement.dto.BookBean;

public class BookDAOImp implements BookDAO{

	public boolean search(int id) {
		for(BookBean bean : DataBase.book) {
			if(bean.equals(id)) {
				System.out.println("Book Found");
				return true;
			} else {
				System.out.println("Book Not Found");
			}
		}
		return false;
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
		for(BookBean bean : DataBase.book) {
			if(bean != null) {
				System.out.println("Book Added");
				return true;
			} else {
				System.out.println("Book Not Added");
			}
		}
		return false;
	}

	public boolean delete(String name, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
