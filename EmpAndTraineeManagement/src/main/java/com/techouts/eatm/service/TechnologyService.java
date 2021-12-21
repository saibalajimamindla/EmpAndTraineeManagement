package com.techouts.eatm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.techouts.eatm.Dao.TechnologyDao;
import com.techouts.eatm.converter.TechnologyConvertor;
import com.techouts.eatm.dto.TechnologyDto;
import com.techouts.eatm.model.Technology;

@Service
public class TechnologyService {
	@Autowired
	TechnologyDao technologyDao;
	
	@Autowired
	TechnologyConvertor technologyConvertor;

	public String addTechnologytoDatabase(TechnologyDto techDto) {

		Technology tech = technologyDao.findByName(techDto.getTechnologyName().toString());

		if (tech == null) {
			technologyDao.save(technologyConvertor.DtoTomodel(techDto));
			return "ok";
		} else {
			tech.setTechnologyduration(techDto.getTechnologyduration());
			tech.setTechnologyType(techDto.getTechnologyType());
			technologyDao.save(tech);
			System.out.println("alreddy exists updated");
			return "nok";
		}

	}

	public void removeTechnologyfromDatabase(String tech) {
		Technology technology = technologyDao.findByName(tech);
		if (technology != null) {
			technologyDao.removeByName(tech);
			/* technologyDao.delete(technology); */
		}

	}
	
	
	public List<TechnologyDto> getTchnologies()
	{
		return technologyConvertor.modelListToDtoList(technologyDao.findAll());
		
	}
	
	
	public List<TechnologyDto> getTechnologiesByType(String Type)
	{
		return technologyConvertor.modelListToDtoList(technologyDao.findBytype(Type));
		
	}
	
	
	public TechnologyDto getBytechnologyName(String Name)
	{
		return technologyConvertor.modelToDto(technologyDao.findByName(Name));
	}
}
