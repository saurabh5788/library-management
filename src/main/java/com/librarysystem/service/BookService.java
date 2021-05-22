package com.librarysystem.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface BookService {

	
	ResponseEntity<?> returnBooks();
	
}
