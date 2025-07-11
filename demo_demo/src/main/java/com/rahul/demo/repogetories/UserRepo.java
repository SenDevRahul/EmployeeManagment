package com.rahul.demo.repogetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.demo.entities.User;

public interface UserRepo extends JpaRepository<User, String>{

}
