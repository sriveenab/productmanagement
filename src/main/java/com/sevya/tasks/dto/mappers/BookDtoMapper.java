package com.sevya.tasks.dto.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sevya.tasks.dto.BookDto;
import com.sevya.tasks.model.Book;

public class BookDtoMapper {

	public static List<BookDto> toBookDtos(List<Book> books) {

		List<BookDto> bookDtos = new ArrayList<>();
		for (Book book : books) {
			bookDtos.add(toBookDto(book));
		}
		return bookDtos;
	}

	public static BookDto toBookDto(Book book) {

		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setBookName(book.getBookName());
		bookDto.setCost(book.getCost());
		bookDto.setDateOfPurchase(book.getDateOfPurchase().toString());
		bookDto.setNumOfCopies(book.getNumOfCopies());
		bookDto.setTechnology(TechnologyDtoMapper.toTechnologyDto(book.getTechnology()));
		return bookDto;

	}

	public static Book toBook(BookDto bookDto) throws ParseException {

		Book book = new Book();
		book.setCreatedDate(new Date());
		book.setBookName(bookDto.getBookName());
		book.setCost(bookDto.getCost());
		book.setNumOfCopies(bookDto.getNumOfCopies());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date langDate = sdf.parse(bookDto.getDateOfPurchase());
		book.setDateOfPurchase(langDate);
		return book;

	}
}
