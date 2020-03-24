package com.capgemini.librarymangemtsystemhibernate.factory;

import com.capgemini.librarymangemtsystemhibernate.dao.UsersDAO;
import com.capgemini.librarymangemtsystemhibernate.dao.UsersDAOImp;
import com.capgemini.librarymangemtsystemhibernate.service.UsersService;
import com.capgemini.librarymangemtsystemhibernate.service.UsersServiceImp;

public class UsersFactory {
	public static UsersDAO getUsersDAO() {
		return new UsersDAOImp();
	}
	public static UsersService  getUsersService() {
		return (UsersService) new UsersServiceImp();
	}
}
