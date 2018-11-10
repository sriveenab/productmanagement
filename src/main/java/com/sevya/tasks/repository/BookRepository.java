package com.sevya.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	@Query("FROM Book book")
	public List<Book> getAllBooks();
	
	@Query("FROM Book book where book.id = :id")
	public Book getBookById(@Param("id") Integer id);
	
}
