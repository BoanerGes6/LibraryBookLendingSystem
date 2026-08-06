package com.LibraryBook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryBook.entity.Member;
import com.LibraryBook.service.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> Register(@Valid @RequestBody Member member) {
		
		return memberService.addMember(member);
	}
	
	@PostMapping("/borrowBook")
	public void borrowBook(@RequestParam Long bookId) {
		memberService.borrow(bookId);
	}
}
