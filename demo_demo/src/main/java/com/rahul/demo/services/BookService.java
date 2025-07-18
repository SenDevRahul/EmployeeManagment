package com.rahul.demo.services;

import java.util.List;
import java.util.Optional;

import com.rahul.demo.entities.Book;

public interface BookService {
	Book saveBook(Book book);
	
	List<Book> getAllBooks();
	
	Optional<Book> getSingleBook(String Id);

	void deleteBook(Book book);

}
