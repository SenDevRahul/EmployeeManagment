package com.rahul.demo.restController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.demo.entities.Book;
import com.rahul.demo.entities.Employee;
import com.rahul.demo.services.BookService;

@RestController
@RequestMapping("/book")
public class BookRestCtrl {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/saveBook")
	public ResponseEntity<?> saveBook( @RequestBody Book book){
		String randomNum = UUID.randomUUID().toString();
		book.setBookId(randomNum);
	  Book book2=bookService.saveBook(book);
	  return ResponseEntity.ok(book2);
	}
	
	@GetMapping("/getBook")
	public ResponseEntity<?> getBook(){
	  List<Book> book2=bookService.getAllBooks();
	  return ResponseEntity.ok(book2);
	}
	
	@GetMapping("/deleteBook/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable String  bookId){
		bookService.deleteBook(Book.builder().bookId(bookId).build());
	  return ResponseEntity.ok(true);
	}
	
	@GetMapping("/getSingleBook/{bookId}")
	public ResponseEntity<?> getEmployee(@PathVariable String  bookId){
	   Optional<Book> book= bookService.getSingleBook(bookId);
	  return ResponseEntity.ok(book.get());
	}

}
