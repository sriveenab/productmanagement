package com.sevya.tasks.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="technology")
public class Technology extends BaseModel {

	private String technologyName;

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	
	
}
