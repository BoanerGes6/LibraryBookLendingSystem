package com.LibraryBook.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LibraryBook.entity.Book;
import com.LibraryBook.entity.Loan;
import com.LibraryBook.entity.LoanStatus;
import com.LibraryBook.entity.Member;
import com.LibraryBook.exceptions.BookLimitExceedException;
import com.LibraryBook.exceptions.BookNotFound;
import com.LibraryBook.exceptions.MemberNotFound;
import com.LibraryBook.repository.BookRepository;
import com.LibraryBook.repository.LoanRepository;
import com.LibraryBook.repository.MemberRepository;

@Service
public class LoanService {
	
	private final LoanRepository loanRepo;
	
	public LoanService(LoanRepository loanRepo) {
		this.loanRepo = loanRepo;
	}
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private MemberRepository memberRepo;

	
	public ResponseEntity<?> borrow(Long bookId, Long memId) {
		
			Book book = bookRepo.findById(bookId).orElseThrow(() -> 
					new BookNotFound("Book Not Found or Currently Unavailable"));
			
			Member member = memberRepo.findById(memId).orElseThrow(() -> 
					new MemberNotFound("Unable to Find Membership"));
			
			Loan loan = new Loan();
			loan.setBook(book);
			loan.setMember(member);
			LocalDate date = LocalDate.now();
			loan.setBorrowDate(date);
			LocalDate dueDate = LocalDate.now().plusDays(14);
			loan.setDueDate(dueDate);
			loan.setReturnDate(dueDate);
			loan.setLoanStatus(LoanStatus.BORROWED);
			
			Loan loned = loanRepo.save(loan);
			
			return ResponseEntity.status(HttpStatus.OK).body(loned);
	}
}
