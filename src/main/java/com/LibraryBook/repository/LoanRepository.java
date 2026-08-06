package com.LibraryBook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryBook.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	Optional<Loan> findAllByMemberId(Long id);
}
