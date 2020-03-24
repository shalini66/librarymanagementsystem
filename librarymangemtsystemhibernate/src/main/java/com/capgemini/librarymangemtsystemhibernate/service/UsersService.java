package com.capgemini.librarymangemtsystemhibernate.service;

import com.capgemini.librarymangemtsystemhibernate.dto.UsersBean;

public interface UsersService {
	boolean register(UsersBean info);
	UsersBean auth(String email, String password);
}
