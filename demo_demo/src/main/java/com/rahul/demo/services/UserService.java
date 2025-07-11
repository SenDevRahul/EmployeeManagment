package com.rahul.demo.services;

import com.rahul.demo.entities.User;

public interface UserService {

	User createUser(User user);
	
	boolean userLogin(User user);
}
