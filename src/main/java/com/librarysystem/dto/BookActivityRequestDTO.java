package com.librarysystem.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookActivityRequestDTO {

	private ArrayList<Integer> bookIds;

	private LocalDate borrowedDate;

	private LocalDate returnDate;

	/**
	 * @return the bookIds
	 */
	public ArrayList<Integer> getBookIds() {
		return bookIds;
	}

	/**
	 * @param bookIds the bookIds to set
	 */
	public void setBookIds(ArrayList<Integer> bookIds) {
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
