package com.techouts.eatm.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "training_tracks")
public class TrainingTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true,name = "track_name")
	private String trackName;

	@OneToOne(mappedBy = "trainingTrack")
	// trainingTrack in mapped by indicates the field that own the relationship in the other class
	private Employee employee;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "techtrack_tech" ,
	joinColumns = {@JoinColumn(name="techtrack_id")},
	inverseJoinColumns = {@JoinColumn(name="tech_id")})
	private Set<Technology> technologies = new HashSet<>();

	public TrainingTrack() {
		super();
	}
	

	
	public TrainingTrack(String trackName) {
		super();
		this.trackName = trackName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Set<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Set<Technology> technologies) {
		this.technologies = technologies;
	}
	
	
	
	
	
	
	
	
}
