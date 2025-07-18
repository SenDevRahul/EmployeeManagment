package com.rahul.demo.repogetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.demo.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, String>{

}
