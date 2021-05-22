package com.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.librarysystem.entities.Book;
import com.librarysystem.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}
	
	@Override
	public ResponseEntity<?> returnBooks() {
		// TODO Auto-generated method stub
		
		//Book ids
		//user id
		//borrowed date
		
		//Check if books with that id exist, if yes
		//calculate the difference betweeen borrowed date and return date
		//update the books tbale with status AVAILABLE for that id
		//update the UserActitvityLog table and then return the response
		
		
		return null;
	}

	@Override
	public List<Book> fetchBooksByAuthorTitleCategory(String author,
			String title, Integer categoryId){
		List<Book> bookList = bookRepository.fetchBooksByAuthorTitleCategory(author,
				title, categoryId);
		return bookList;
	}
	
}
