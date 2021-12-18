package com.techouts.eatm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class TrainingTrack {
	
	@Id
	 @GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy = "trainingTrack")
	private Employee employee;

	public TrainingTrack() {
		super();
	}

	public TrainingTrack(Employee employee) {
		super();
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
