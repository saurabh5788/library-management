package com.librarysystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.dto.BookActivityRequestDTO;
import com.librarysystem.dto.BookActivityResponseDTO;
import com.librarysystem.service.BookService;

@RestController
@RequestMapping( MediaType.APPLICATION_JSON_VALUE)
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/{userid}/books")
	public ResponseEntity<?> fetchBooksByUser(
			@PathVariable("userid") String userId,
			@RequestParam Optional<String> authorName,
			@RequestParam Optional<String> title,
			@RequestParam Optional<String> category,
			@RequestParam String pageNo) {
		return null;
	}
	
	
	@PostMapping("/users/{userid}/books")
	public ResponseEntity<BookActivityResponseDTO> returnBooks(@PathVariable("userid") int userId,@RequestBody BookActivityRequestDTO bookActivityRequestDTO){
		
		return bookService.returnBooks(userId, bookActivityRequestDTO);
	}
}
