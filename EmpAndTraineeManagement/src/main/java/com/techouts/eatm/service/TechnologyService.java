package com.techouts.eatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.techouts.eatm.Dao.TechnologyDao;
import com.techouts.eatm.model.Technology;

@Service
public class TechnologyService {
	@Autowired
	TechnologyDao technologyDao;

	public String addTechnologytoDatabase(Technology tech) {

		Technology tech1 = technologyDao.findByName(tech.getTechnologyName());
		System.out.println(tech1);

		if (tech1 == null) {
			technologyDao.save(tech);
			return "ok";
		} else {
			System.out.println("alreddy exists");
			return "nok";
		}

	}

	public void removeTechnologyfromDatabase(String tech) {
		Technology technology = technologyDao.findByName(tech);
		if(technology!=null)
		{
			/* technologyDao.removeByName(tech); */
			technologyDao.delete(technology);
		}
	
		
	}
}
