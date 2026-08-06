package com.LibraryBook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryBook.entity.Book;
import com.LibraryBook.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping("/new-book")
	public ResponseEntity<?> newBook(@Valid @RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping("/books")
	public ResponseEntity<?> allBooks() {
		return bookService.getAllBooks();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
	
	@GetMapping("/searchBook")
	public ResponseEntity<Book> search(@RequestParam String payload) {
		return bookService.findBook(payload);
	}
	
}
