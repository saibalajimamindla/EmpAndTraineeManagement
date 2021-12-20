package com.techouts.eatm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "technologies")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true,name = "technology_name")
	private String TechnologyName;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "technologies")
	private Set<TrainingTrack> tracks = new HashSet<>();
	
	

	public Technology() {
		super();
	}

	public Technology(String technologyName) {
		super();
		TechnologyName = technologyName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTechnologyName() {
		return TechnologyName;
	}

	public void setTechnologyName(String technologyName) {
		TechnologyName = technologyName;
	}

	public Set<TrainingTrack> getTracks() {
		return tracks;
	}

	public void setTracks(Set<TrainingTrack> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Technology [TechnologyName=" + TechnologyName + "]";
	}
	
	

}
