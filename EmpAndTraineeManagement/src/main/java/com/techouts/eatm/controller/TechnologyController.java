package com.techouts.eatm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techouts.eatm.model.Technology;
import com.techouts.eatm.service.TechnologyService;

@RestController
public class TechnologyController {
	
	@Autowired
	TechnologyService technologyService;
	
	
	
	@PostMapping("/addTecnology")
	@ResponseBody
	public String addTechnology(@RequestParam String technology)
	{
		return technologyService.addTechnologytoDatabase(new Technology(technology));
	}
	
	
	@PostMapping("/removeTecnology")
	@Modifying
	public void removeTechnology(@RequestParam String name)
	{
		technologyService.removeTechnologyfromDatabase(name);
	}

}
