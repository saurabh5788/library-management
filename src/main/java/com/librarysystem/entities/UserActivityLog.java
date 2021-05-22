package com.librarysystem.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_activity_log")
public class UserActivityLog {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int logId;
	
	@Column
	private int userId;
	
	@Column
	private int bookId;
	
	@Column
	private LocalDate borrowDate;
	
	@Column
	private LocalDate returnDate;
	
	@Column
	private double charge;

	/**
	 * @return the logId
	 */
	public int getLogId() {
		return logId;
	}

	/**
	 * @param logId the logId to set
	 */
	public void setLogId(int logId) {
		this.logId = logId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the borrowDate
	 */
	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	/**
	 * @param borrowDate the borrowDate to set
	 */
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
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

	/**
	 * @return the charge
	 */
	public double getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	
	
	
}
