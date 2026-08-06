package com.LibraryBook.exceptions;

public class BookLimitExceedException extends RuntimeException {

	BookLimitExceedException(String message) {
		super(message);
	}
}
