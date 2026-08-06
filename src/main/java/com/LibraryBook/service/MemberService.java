package com.LibraryBook.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LibraryBook.entity.Member;
import com.LibraryBook.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepo;
	
	public MemberService(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}
	
	public ResponseEntity<?> addMember(Member member) {
		
		Member saved = memberRepo.save(member);
		
		return ResponseEntity.ok(saved);
	}
	
}
