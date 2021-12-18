package com.techouts.eatm.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private int empId;
	
	private String empName;
	
	private Date dateOfJoining;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "track_id", referencedColumnName = "id")
	private TrainingTrack trainingTrack;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public TrainingTrack getTrainingTrack() {
		return trainingTrack;
	}

	public void setTrainingTrack(TrainingTrack trainingTrack) {
		this.trainingTrack = trainingTrack;
	}

	public Employee(int empId, String empName, Date dateOfJoining, TrainingTrack trainingTrack) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dateOfJoining = dateOfJoining;
		this.trainingTrack = trainingTrack;
	}

	public Employee() {
		super();
	}
	
	
	
	
	
	
	
	
	

}
