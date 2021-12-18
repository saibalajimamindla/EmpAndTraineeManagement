package com.techouts.eatm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techouts.eatm.model.TrainingTrack;

@Repository
public interface TrainingTrackDao extends JpaRepository<TrainingTrack, Long> {

}
