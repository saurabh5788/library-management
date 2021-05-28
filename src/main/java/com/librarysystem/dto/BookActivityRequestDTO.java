package com.librarysystem.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

public class BookActivityRequestDTO {

	@NotEmpty(message = "Book ids cannot be empty")
	private List<Integer> bookIds;

	@Past(message = "Borrow date cannot be current or future date")
	private LocalDate borrowedDate;

	private LocalDate returnDate;

	
	
	
	
	/**
	 * @return the bookIds
	 */
	public List<Integer> getBookIds() {
		return bookIds;
	}

	/**
	 * @param bookIds the bookIds to set
	 */
	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
	}

	/**
	 * @return the borrowedDate
	 */
	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	/**
	 * @param borrowedDate the borrowedDate to set
	 */
	public void setBorrowedDate(LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	/**
	 * @return the returnDate
	 */
	public LocalDate getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

}
