package com.librarysystem.controller;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MediaType.APPLICATION_JSON_VALUE)
public class BookController {

	@GetMapping("/{userid}/books")
	public ResponseEntity<?> fetchBooksByUser(
			@PathVariable("userid") String userId,
			@RequestParam Optional<String> authorName,
			@RequestParam Optional<String> title,
			@RequestParam Optional<String> category,
			@RequestParam String pageNo) {
		return null;
	}
}
