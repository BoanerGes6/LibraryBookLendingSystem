package com.LibraryBook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryBook.entity.Member;
import com.LibraryBook.service.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class MemberController {

	private final MemberService memberSevice;
	
	public MemberController(MemberService memberService) {
		this.memberSevice = memberService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> Register(@Valid @RequestBody Member member) {
		
		return memberSevice.addMember(member);
	}
	
	public void updateMember() {
		
	}
}
