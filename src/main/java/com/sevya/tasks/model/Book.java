package com.sevya.tasks.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends BaseModel {

	private String bookName;
	private Float cost;
	private Date dateOfPurchase;
	private Integer numOfCopies;

	@ManyToOne(targetEntity = Technology.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "technologyId")
	private Technology technology;

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

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Integer getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(Integer numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

}
