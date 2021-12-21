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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "technologies")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true,name = "technology_name")
	private String TechnologyName;
	
	@Column(name = "technology_type")
	private String TechnologyType;
	
	@Column(name = "technology_duration")
	private long Technologyduration;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "technologies")
	private Set<TrainingTrack> tracks = new HashSet<>();
	
	
	public Technology() {
		super();
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

	public String getTechnologyType() {
		return TechnologyType;
	}

	public void setTechnologyType(String technologyType) {
		TechnologyType = technologyType;
	}

	public long getTechnologyduration() {
		return Technologyduration;
	}

	public void setTechnologyduration(long technologyduration) {
		Technologyduration = technologyduration;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", TechnologyName=" + TechnologyName + ", TechnologyType=" + TechnologyType
				+ ", Technologyduration=" + Technologyduration + ", tracks=" + tracks + "]";
	}

	
	
	

}
