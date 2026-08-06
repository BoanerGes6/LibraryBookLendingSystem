package com.LibraryBook.exceptions;

public class BookLimitExceedException extends RuntimeException {

	public BookLimitExceedException(String message) {
		super(message);
	}
}
