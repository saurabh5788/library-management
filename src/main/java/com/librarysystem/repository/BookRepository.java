package com.librarysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.librarysystem.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query("SELECT b FROM Book b "
			+ "WHERE "
			+ "(:author is null or b.author = :author) "
			+ "and (:title is null or b.title = :title) "
			+ "and (:categoryId is null or b.category.id = :categoryId)")
	List<Book> fetchBooksByAuthorTitleCategory(@Param("author") String author,
			@Param("title") String title,
			@Param("categoryId") Integer categoryId);

}
