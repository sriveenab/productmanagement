package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Book;

public interface BookService  {

	public List<Book> getAllBooks();
	
	public Book saveBook(Book book);
	
	public Book getBookById(Integer id);
	
}
