 package com.techouts.eatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.eatm.Dao.TechnologyDao;
import com.techouts.eatm.Dao.TrainingTrackDao;
import com.techouts.eatm.model.Technology;
import com.techouts.eatm.model.TrainingTrack;

@Service
public class TrainingTrackService {
	@Autowired
	TrainingTrackDao trainingTrackDao;
	
	@Autowired
	TechnologyDao technologyDao;
	
	public void savetracktoDatabase()
	{
		TrainingTrack trainingTrack= new TrainingTrack("hybris");
		
		Technology technology1 =(Technology) technologyDao.getById((long) 9);
		Technology technology2 =(Technology) technologyDao.getById((long) 10);
		
		  trainingTrack.getTechnologies().add(technology1);
		  trainingTrack.getTechnologies().add(technology2);
		  
		  technology1.getTracks().add(trainingTrack);
		  technology2.getTracks().add(trainingTrack);
		  
		  trainingTrackDao.save(trainingTrack);
		  
			
		 
		/* trainingTrackDao.save(trainingTrack); */
		/*
		 * trainingTrack.getTechnologies().add(technologyDao.findByName("java"));
		 * trainingTrack.getTechnologies().add(technologyDao.findByName("html"));
		 * trainingTrack.getTechnologies().add(technologyDao.findByName("css"));
		 * trainingTrack.getTechnologies().add(technologyDao.findByName("advanced java")
		 * ); trainingTrack.getTechnologies().add(technologyDao.findByName("hybris"));
		 */
		
		/*
		 * technologyDao.findByName("java").getTracks().add(trainingTrack);
		 * technologyDao.findByName("html").getTracks().add(trainingTrack);
		 * technologyDao.findByName("css").getTracks().add(trainingTrack);
		 * technologyDao.findByName("advanced java").getTracks().add(trainingTrack);
		 * technologyDao.findByName("hybris").getTracks().add(trainingTrack);
		 */
		
		/* trainingTrackDao.save(trainingTrack); */
		
	}

}
