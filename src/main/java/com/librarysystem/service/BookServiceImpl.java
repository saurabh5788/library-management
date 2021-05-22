package com.librarysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.librarysystem.dto.BookActivityRequestDTO;
import com.librarysystem.dto.BookActivityResponseDTO;
import com.librarysystem.entities.UserActivityLog;
import com.librarysystem.repository.BookRepository;
import com.librarysystem.repository.UserActivityRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	UserActivityRepository userActivityRepository;

	@Autowired
	BookRepository bookRepository;

	/**
	 * Assumptions : 1) User has already logged in 2) The user has valid books with
	 * him/her
	 */
	@Override
	public ResponseEntity<BookActivityResponseDTO> returnBooks(int userid,
			BookActivityRequestDTO bookActivityRequestDTO) {
		double chargeForLateReturn = 0.0;
		long allowedDays = 10;
		if (!bookActivityRequestDTO.getBookIds().isEmpty()) {

			List<UserActivityLog> userActivityLog = userActivityRepository
					.findAllById(bookActivityRequestDTO.getBookIds());
			for (UserActivityLog userLog : userActivityLog) {
				LocalDate borrowedDate = userLog.getBorrowDate();
				LocalDate currentDate = LocalDate.now();
				long noOfDaysBetween = ChronoUnit.DAYS.between(currentDate, borrowedDate);
				if (noOfDaysBetween > allowedDays) {
					chargeForLateReturn = chargeForLateReturn + calculateLateFee(noOfDaysBetween, allowedDays);
				}
				boolean updateBookStatus = bookRepository.updateBookStatus("AVAILABLE", userLog.getBookId());
			}
			
			
			
		}
		return null;
	}

	private double calculateLateFee(long numberOfDays, long allowedDays) {
		long daysToBeCharged=numberOfDays-allowedDays;
		double lateFees=0.0;
		if(daysToBeCharged < 4){
			lateFees = daysToBeCharged*20;
		}else {
			lateFees = daysToBeCharged*50;
		}
		return lateFees;
	}

}
