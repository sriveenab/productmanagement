package com.sevya.tasks.dto.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sevya.tasks.dto.StudentDto;
import com.sevya.tasks.model.Student;

public class StudentDtoMapper {

	public static List<StudentDto> toStudentDtos(List<Student> students) {

		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : students) {
			studentDtos.add(toStudentDto(student));
		}
		return studentDtos;
	}

	public static StudentDto toStudentDto(Student student) {

		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setBook(BookDtoMapper.toBookDto(student.getBook()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String langDate = sdf.format(student.getDateOfIssue());
		studentDto.setDateOfIssue(langDate);
		studentDto.setStudentName(student.getStudentName());
		return studentDto;
	}

	public static Student toStudent(StudentDto studentDto) throws ParseException {

		Student student = new Student();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date langDate = sdf.parse(studentDto.getDateOfIssue());
		student.setDateOfIssue(langDate);
		student.setStudentName(studentDto.getStudentName());
		return student;
	}

}
