package com.librarysystem.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("error")
public class ErrorDTO{
	private String message;

	public ErrorDTO(String message) {		
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
