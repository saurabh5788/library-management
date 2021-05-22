package com.librarysystem.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.librarysystem.dto.BookActivityRequestDTO;
import com.librarysystem.dto.BookActivityResponseDTO;
import com.librarysystem.entities.Book;
import com.librarysystem.entities.UserActivityLog;
import com.librarysystem.repository.BookRepository;
import com.librarysystem.repository.UserActivityRepository;

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

	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public ResponseEntity<BookActivityResponseDTO> returnBooks(int userid,
			BookActivityRequestDTO bookActivityRequestDTO) {
		double chargeForLateReturn = 0.0;
		long allowedDays = 14;
		BookActivityResponseDTO bookActivityResponseDTO;
		if (!bookActivityRequestDTO.getBookIds().isEmpty()) {
			List<UserActivityLog> userActivityLog = userActivityRepository
					.findAllById(bookActivityRequestDTO.getBookIds());
			if (!userActivityLog.isEmpty()) {
				for (UserActivityLog userLog : userActivityLog) {
					LocalDate borrowedDate = userLog.getBorrowDate();
					LocalDate currentDate = LocalDate.now();
					long noOfDaysBetween = ChronoUnit.DAYS.between(currentDate, borrowedDate);
					if (noOfDaysBetween > allowedDays) {
						chargeForLateReturn = chargeForLateReturn + calculateLateFee(noOfDaysBetween, allowedDays);
					}
					boolean updateBookStatus = bookRepository.updateBookStatus("AVAILABLE", userLog.getBookId());
					boolean updateUserActivityLogStatus = userActivityRepository.updateUserActivityLogsForBookReturn(
							userid, chargeForLateReturn, currentDate, userLog.getLogId());
					if (updateBookStatus && updateUserActivityLogStatus) {
						bookActivityResponseDTO = new BookActivityResponseDTO("Books returned Successfully",
								HttpStatus.OK.toString());
						return new ResponseEntity<>(bookActivityResponseDTO, HttpStatus.OK);
					}
				}
			} else {
				bookActivityResponseDTO = new BookActivityResponseDTO("No details found for the given book ids",
						HttpStatus.NOT_FOUND.toString());
				return new ResponseEntity<>(bookActivityResponseDTO, HttpStatus.NOT_FOUND);
			}

		} else {
			bookActivityResponseDTO = new BookActivityResponseDTO("Request parameters cannot be null or empty",
					HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(bookActivityResponseDTO, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	private double calculateLateFee(long numberOfDays, long allowedDays) {
		long daysToBeCharged = numberOfDays - allowedDays;
		double lateFees = 0.0;
		if (daysToBeCharged < 4) {
			lateFees = daysToBeCharged * 20;
		} else {
			lateFees = daysToBeCharged * 50;
		}
		return lateFees;
	}

	@Override
	public List<Book> fetchBooksByAuthorTitleCategory(String author, String title, Integer categoryId) {
		List<Book> bookList = bookRepository.fetchBooksByAuthorTitleCategory(author, title, categoryId);
		return bookList;
	}

}
