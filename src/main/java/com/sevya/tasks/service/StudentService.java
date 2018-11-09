package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Student;

public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getStudentsByBookId(Integer bookId);
	
}
