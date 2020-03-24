package com.capgemini.librarymangemtsystemhibernate.service;

import com.capgemini.librarymangemtsystemhibernate.dao.UsersDAO;
import com.capgemini.librarymangemtsystemhibernate.dto.UsersBean;
import com.capgemini.librarymangemtsystemhibernate.factory.UsersFactory;

public class UsersServiceImp implements UsersService{
	UsersDAO dao = UsersFactory.getUsersDAO();
	@Override
	public boolean register(UsersBean info) {
		
		return dao.register(info);
	}

	@Override
	public UsersBean auth(String email, String password) {
		
		return dao.auth(email, password);
	}

}