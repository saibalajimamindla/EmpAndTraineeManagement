package com.techouts.eatm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class TrainingTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String trackName;

	@OneToOne(mappedBy = "trainingTrack")
	// trainingTrack in mapped by indicates the field that own the relationship in the other class
	private Employee employee;
	
	 @OneToMany(mappedBy = "trainingTrack", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Technologies> technologies;

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Technologies> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technologies> technologies) {
		this.technologies = technologies;
	}

	public TrainingTrack(String trackName) {
		super();
		this.trackName = trackName;
	
	}

	public TrainingTrack() {
		super();
	}


	
	
	

}
