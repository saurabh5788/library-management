package com.librarysystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.librarysystem.entities.Book;
import com.librarysystem.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BookServiceImpl.class);
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
		LOGGER.info("fetching Books by : {}, {}, {}",author,title,categoryId);
		List<Book> bookList = bookRepository.fetchBooksByAuthorTitleCategory(author,
				title, categoryId);
		return bookList;
	}
	
}
