package com.techouts.eatm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techouts.eatm.dto.TechnologyDto;
import com.techouts.eatm.model.Technology;
import com.techouts.eatm.service.TechnologyService;

@RestController
@RequestMapping("/technology")
public class TechnologyController {
	
	@Autowired
	TechnologyService technologyService;
	
	
	
	@GetMapping("/add")
	@ResponseBody
	public TechnologyDto addTechnology()
	{
		return new TechnologyDto();
	}
	
	@PostMapping("/add")
	@ResponseBody
	public String addTechnology(@ModelAttribute TechnologyDto technologyDto)
	{
		System.out.println(technologyDto.toString());
		return technologyService.addTechnologytoDatabase(technologyDto);
	}
	
	@GetMapping("/update/{name}")
	public TechnologyDto updateTechnology(@PathVariable String name)
	{
		return technologyService.getBytechnologyName(name);
	}
	
	
	@DeleteMapping("/remove/{name}")
	public void removeTechnology(@PathVariable String name)
	{
		technologyService.removeTechnologyfromDatabase(name);
	}
	
	@GetMapping("/all")
	public List<TechnologyDto> getTechnologies()
	{
		return technologyService.getTchnologies();
	}
	
	@GetMapping("/all/{type}")
	public List<TechnologyDto> getTechnologiesByType(@PathVariable String type)
	{
		return technologyService.getTechnologiesByType(type);
	}
	

}
