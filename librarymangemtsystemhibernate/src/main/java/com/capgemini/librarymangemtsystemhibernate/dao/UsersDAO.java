package com.capgemini.librarymangemtsystemhibernate.dao;

import com.capgemini.librarymangemtsystemhibernate.dto.UsersBean;

public interface UsersDAO {
	boolean register(UsersBean info);
	UsersBean auth(String email, String password);
}
