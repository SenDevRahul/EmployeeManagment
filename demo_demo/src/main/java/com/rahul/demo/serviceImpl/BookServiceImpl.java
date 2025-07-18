package com.rahul.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.demo.entities.Book;
import com.rahul.demo.repogetories.BookRepo;
import com.rahul.demo.services.BookService;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepo bookRepo;
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Optional<Book> getSingleBook(String bookId) {
		// TODO Auto-generated method stub
		return bookRepo.findById(bookId);
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		bookRepo.delete(book);
	}

}
