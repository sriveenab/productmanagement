package com.sevya.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Student;
import com.sevya.tasks.repository.StudentRepository;
import com.sevya.tasks.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentsByBookId(Integer bookId) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentsByBookId(bookId);
	}

	
}
