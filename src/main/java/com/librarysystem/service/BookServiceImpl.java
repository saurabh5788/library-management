package com.librarysystem.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

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

}
