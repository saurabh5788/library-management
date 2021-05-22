package com.librarysystem.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

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
			List<UserActivityLog> userActivityLogList = userActivityRepository
					.findAllById(bookActivityRequestDTO.getBookIds());
			if (!userActivityLogList.isEmpty()) {
				for (UserActivityLog userLog : userActivityLogList) {
					LocalDate borrowedDate = userLog.getBorrowDate();
					LocalDate currentDate = LocalDate.now();
					long noOfDaysBetween = ChronoUnit.DAYS.between(currentDate, borrowedDate);
					if (noOfDaysBetween > allowedDays) {
						chargeForLateReturn = chargeForLateReturn + calculateLateFee(noOfDaysBetween, allowedDays);
					}
					UserActivityLog userActivityLog = new UserActivityLog();
					userActivityLog.setLogId(userLog.getLogId());
					userActivityLog.setBookId(userLog.getBookId());
					userActivityLog.setBorrowDate(bookActivityRequestDTO.getBorrowedDate());
					userActivityLog.setCharge(chargeForLateReturn);
					userActivityLog.setReturnDate(currentDate);
					userActivityLog.setUserId(userid);
					userActivityRepository.save(userActivityLog);

					bookActivityResponseDTO = new BookActivityResponseDTO("Books returned Successfully",
							HttpStatus.OK.toString());
					return new ResponseEntity<>(bookActivityResponseDTO, HttpStatus.OK);

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
	public List<Book> fetchBooksByAuthorTitleCategory(String author,
			String title, Integer categoryId, int pageNo, int pageSize){
		LOGGER.info("fetching Books by : {}, {}, {}",author,title,categoryId);
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		List<Book> bookList = bookRepository.fetchBooksByAuthorTitleCategory(author,
				title, categoryId, pageable);
		return bookList;
	}

}
