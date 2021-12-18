package com.techouts.eatm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Technologies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String TechnologyName;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Technologies", nullable = false)
    private TrainingTrack trainingTrack;

	public Technologies(String name, TrainingTrack trainingTrack) {
		super();
		this.TechnologyName = name;
		this.trainingTrack = trainingTrack;
	}

	public Technologies() {
		super();
	}

	public String getTechnologyName() {
		return TechnologyName;
	}

	public void setTechnologyName(String name) {
		this.TechnologyName = name;
	}

	public TrainingTrack getTrainingTrack() {
		return trainingTrack;
	}

	public void setTrainingTrack(TrainingTrack trainingTrack) {
		this.trainingTrack = trainingTrack;
	}
	
	

}
