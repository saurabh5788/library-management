package com.librarysystem.dto;

import java.util.List;

import com.librarysystem.entities.Book;

public class BooksResponseDTO {
	private List<Book> bookList;

	public BooksResponseDTO(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}
	public List<Book> getBookList() {
		return bookList;
	}
}
