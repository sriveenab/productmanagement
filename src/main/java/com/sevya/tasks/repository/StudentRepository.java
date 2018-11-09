package com.sevya.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	@Query("FROM Student student where student.book.id = :bookId")
	public List<Student> getStudentsByBookId(@Param("bookId") Integer bookId);	

}
