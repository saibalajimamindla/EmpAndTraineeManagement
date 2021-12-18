package com.techouts.eatm.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techouts.eatm.Dao.EmployeeDao;
import com.techouts.eatm.model.Employee;
import com.techouts.eatm.model.TrainingTrack;

@RestController
public class MainController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@PostMapping("/add")
	public void addData() throws ParseException
	{
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = format.parse("03/24/2011");
		/* new Employee(10,"balaji",date,new TrainingTrack("hybris")); */
		
		employeeDao.save(new Employee(10,"balaji",date,new TrainingTrack("hybris")));
		
	}

}
