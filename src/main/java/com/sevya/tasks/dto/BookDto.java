package com.sevya.tasks.dto;

import java.util.List;

public class BookDto {

	private Integer id;
	private String bookName;
	private Float cost;
	private String dateOfPurchase;
	private Integer numOfCopies;
	private TechnologyDto technology;
	private List<StudentDto> students;
	
	
	public List<StudentDto> getListOfStudents() {
		return students;
	}

	public void setListOfStudents(List<StudentDto> students) {
		this.students = students;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public TechnologyDto getTechnology() {
		return technology;
	}

	public void setTechnology(TechnologyDto technology) {
		this.technology = technology;
	}

	public Integer getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(Integer numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
