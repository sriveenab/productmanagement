package com.sevya.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Book;
import com.sevya.tasks.repository.BookRepository;
import com.sevya.tasks.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	public BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookRepository.getAllBooks();
		return books;
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookRepository.getBookById(id);
	}

	
	
}
