package com.librarysystem.dto;

public class BookActivityResponseDTO {
	
	

	public BookActivityResponseDTO(String message, String httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	private String message;
	
	private String httpStatus;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the httpStatus
	 */
	public String getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	
}
