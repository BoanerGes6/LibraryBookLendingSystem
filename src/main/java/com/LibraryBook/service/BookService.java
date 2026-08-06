package com.LibraryBook.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LibraryBook.entity.Book;
import com.LibraryBook.exceptions.BookNotFound;
import com.LibraryBook.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepo;
	
	BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public ResponseEntity<?> saveBook(Book book) {
		Book saved = bookRepo.save(book);
		return ResponseEntity.ok(saved);
	}
	
	public ResponseEntity<?> getAllBooks() {
		
		List<Book> books = bookRepo.findAll();
		if (books.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Book Available");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
	public ResponseEntity<Book> updateBook(Long id, Book book) {
		
		Book existing = bookRepo.findById(id).orElseThrow(() -> 
				new BookNotFound("Unable to Find Book"));
		
		if (existing != null) {
			existing.setTotalCopies(book.getTotalCopies());
			existing.setAvailableCopies(book.getAvailableCopies());
		}
		Book updated = bookRepo.save(existing);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}
	
	public ResponseEntity<Book> findBook(String payload) {
		
		Book book = bookRepo.findByTitleOrAuthor(payload).orElseThrow(() ->
				new BookNotFound("Book Not Found for " + payload));
		
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
}
