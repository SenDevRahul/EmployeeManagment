package com.rahul.demo.restController;

import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.demo.entities.User;
import com.rahul.demo.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserRestCtrl {
	
	@Autowired
	UserServiceImpl userSrImpl;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		System.out.println(user);
	    boolean isAvl=	userSrImpl.userLogin(user);
		if (isAvl)
			return ResponseEntity.ok(isAvl);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<?> save(@RequestBody User user) {
		System.out.println(user);
		String s = UUID.randomUUID().toString().replace("-", "");
		user.setUserId(s);
		User user2=userSrImpl.createUser(user);
		return ResponseEntity.ok(user2);
	}

}
