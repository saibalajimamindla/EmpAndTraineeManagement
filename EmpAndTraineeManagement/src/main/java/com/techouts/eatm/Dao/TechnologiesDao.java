package com.techouts.eatm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techouts.eatm.model.Technologies;

@Repository
public interface TechnologiesDao extends JpaRepository<Technologies, Long> {

}
