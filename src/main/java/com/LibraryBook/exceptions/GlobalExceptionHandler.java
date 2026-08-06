package com.LibraryBook.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<?> HandleBookNotFound(BookNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of(
						"status" , 404,
						"error", "Not Found",
						"message", ex.getMessage()
						));
	}

	@ExceptionHandler(MemberNotFound.class)
	public ResponseEntity<?> HandleMemberNotFound(MemberNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of(
						"status" , 404,
						"error", "Not Found",
						"message", ex.getMessage()
						));
	}
	@ExceptionHandler(BookLimitExceedException.class)
	public ResponseEntity<?> HandleBookLimitExceedException(BookLimitExceedException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of(
						"status" , 404,
						"error", "Not Found",
						"message", ex.getMessage()
						));
	}
}
