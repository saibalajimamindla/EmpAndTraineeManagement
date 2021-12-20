package com.techouts.eatm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techouts.eatm.service.TrainingTrackService;

@RestController
public class TrainingTrackController {
	
	@Autowired
	TrainingTrackService trainingTrackService;
	
	@PostMapping("/addTraingTrack")
	public void addTraingTrack()
	{
		trainingTrackService.savetracktoDatabase();
	}
	
	@PostMapping("/removeTraingTrack")
	public void removeTraingTrack()
	{
		
	}
	
	@PostMapping("/updateTraingTrack")
	public void updateTraingTrack()
	{
		
	}
	
	@PostMapping("/getTraingTracks")
	public void getTraingTracks()
	{
		
	}

}
