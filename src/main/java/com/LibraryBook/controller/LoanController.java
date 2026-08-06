package com.LibraryBook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryBook.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoanController {
	
	private final LoanService loanService;
	
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@PostMapping("/borrowBook")
	public ResponseEntity<?> borrowBook(@RequestParam Long bookId, @RequestParam Long memId) {
		return loanService.borrow(bookId, memId);
	}
}
