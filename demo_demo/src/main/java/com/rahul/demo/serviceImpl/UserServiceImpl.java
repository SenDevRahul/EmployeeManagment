package com.rahul.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.demo.entities.User;
import com.rahul.demo.repogetories.UserRepo;
import com.rahul.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService{
   
	@Autowired
	UserRepo userRepo;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public boolean userLogin(User user) {
		// TODO Auto-generated method stub
		Optional<User> user2=userRepo.findById(user.getUserId());
		if(user2.isPresent()) {
			if(user2.get().getPassword().equals(user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
