package com.librarysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.librarysystem.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	@Query("SELECT b FROM Book b WHERE (:author is null or b.author = :author) and (:title is null or b.author = :title) and (:categoryId is null or b.author = :categoryId)")
	List<Book> fetchBooksByAuthorTitleCategory(@Param("author") String author, @Param("title") String title,
			@Param("categoryId") Integer categoryId);

	@Modifying
	@Query("update bookStatus b set b.status=?1 where b.bookId=?2")
	boolean updateBookStatus(@Param("status") String status, @Param("log_id") Integer categoryId);
}
