package com.LibraryBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LibraryBook.entity.Book;
import com.LibraryBook.entity.Member;
import com.LibraryBook.exceptions.BookNotFound;
import com.LibraryBook.repository.BookRepository;
import com.LibraryBook.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepo;
	
	public MemberService(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}

	@Autowired
	private BookRepository bookRepo;
	
	public ResponseEntity<?> addMember(Member member) {
		
		Member saved = memberRepo.save(member);
		
		return ResponseEntity.ok(saved);
	}
	
	public void borrow(Long bookId) {
		
		Book book = bookRepo.findById(bookId).orElseThrow(() -> 
				new BookNotFound("Book Not Found or Currently Unavailable"));
	}
}
