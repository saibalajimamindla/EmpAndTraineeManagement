package com.techouts.eatm.Dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techouts.eatm.model.TrainingTrack;

@Repository
public interface TrainingTrackDao extends JpaRepository<TrainingTrack, Long> {

	
	@Query(value = "SELECT * FROM training_tracks WHERE track_name=?1",nativeQuery = true)
	@Transactional
	public TrainingTrack getByName(String name);
	
}
