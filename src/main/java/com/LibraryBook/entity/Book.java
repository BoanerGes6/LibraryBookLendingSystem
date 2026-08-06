package com.LibraryBook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String title;
	@NotBlank
	private String author;
	@NotNull
	private Long isbn;
	@NotNull
	private int totalCopies;
	@NotNull
	private int availableCopies;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public int getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	
	
}
