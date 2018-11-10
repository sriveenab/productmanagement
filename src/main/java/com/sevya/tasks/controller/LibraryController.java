package com.sevya.tasks.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sevya.tasks.dto.BookDto;
import com.sevya.tasks.dto.StudentDto;
import com.sevya.tasks.dto.TechnologyDto;
import com.sevya.tasks.dto.mappers.BookDtoMapper;
import com.sevya.tasks.dto.mappers.StudentDtoMapper;
import com.sevya.tasks.dto.mappers.TechnologyDtoMapper;
import com.sevya.tasks.model.Book;
import com.sevya.tasks.model.Student;
import com.sevya.tasks.model.Technology;
import com.sevya.tasks.service.BookService;
import com.sevya.tasks.service.StudentService;
import com.sevya.tasks.service.TechnologyService;

@RestController
public class LibraryController {
	
	@Autowired
	public BookService bookService;

	@Autowired
	public TechnologyService technologyService;
	
	@Autowired
	public StudentService studentService;
	
	@RequestMapping(value = "/book/all", method = RequestMethod.GET)
	public List<BookDto> getBooks() {
		List<Book> books = bookService.getAllBooks();
		List<BookDto> bookDtos = new ArrayList<>();
		for (Book book : books) {
			bookDtos.add(BookDtoMapper.toBookDto(book));
		}
		return bookDtos;
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public BookDto saveBook(@RequestBody BookDto bookDto) throws ParseException {

		Book book = BookDtoMapper.toBook(bookDto);
		Technology technology = technologyService.getTechnologyById(bookDto.getTechnology().getId());
		book.setTechnology(technology);
		book = bookService.saveBook(book);
		return BookDtoMapper.toBookDto(book);
	}

	@RequestMapping(value = "/technologies", method = RequestMethod.GET)
	public List<TechnologyDto> getTechnologies() {

		List<Technology> technologies = technologyService.getAllTechnologies();
		List<TechnologyDto> technologyDtos = new ArrayList<>();
		for (Technology technology : technologies) {
			technologyDtos.add(TechnologyDtoMapper.toTechnologyDto(technology));
		}
		return technologyDtos;
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public StudentDto saveStudent(@RequestBody StudentDto studentDto) throws ParseException {
		
		Student student = StudentDtoMapper.toStudent(studentDto);
		Book book = bookService.getBookById(studentDto.getBook().getId());
		student.setBook(book);
		student = studentService.saveStudent(student);
		book.setNumOfCopies(book.getNumOfCopies() - 1);
		book = bookService.saveBook(book);
		return StudentDtoMapper.toStudentDto(student);
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public BookDto getStudentsOfGivenBook(@PathVariable Integer id) {
		
		BookDto bookDto = new BookDto();
		Book book = bookService.getBookById(id);
		List<Student> students = studentService.getStudentsByBookId(book.getId());
		
		bookDto = BookDtoMapper.toBookDto(book);
		bookDto.setListOfStudents(StudentDtoMapper.toStudentDtos(students));
		
		return bookDto;
		
		
	}
	
}
