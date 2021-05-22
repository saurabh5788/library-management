package com.librarysystem.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.librarysystem.dto.BookActivityRequestDTO;
import com.librarysystem.dto.BookActivityResponseDTO;

@Component
public interface BookService {

	
	ResponseEntity<BookActivityResponseDTO> returnBooks(int userid, BookActivityRequestDTO bookActivityRequestDTO);
	
}
