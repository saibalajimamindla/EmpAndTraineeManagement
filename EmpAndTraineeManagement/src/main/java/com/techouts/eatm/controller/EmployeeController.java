package com.techouts.eatm.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techouts.eatm.Dao.EmployeeDao;
import com.techouts.eatm.Dao.TrainingTrackDao;
import com.techouts.eatm.dto.EmployeeDto;
import com.techouts.eatm.model.Employee;
import com.techouts.eatm.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	TrainingTrackDao trainingTrackDao;
	
	@GetMapping("/add")
	public EmployeeDto getDto()
	{
		return new EmployeeDto();
	}

	@PostMapping("/add")
	@ResponseBody
	public void addEmployee(@RequestBody EmployeeDto empdto) throws ParseException {

		employeeService.saveEmployee(empdto);
		/*
		 * String pattern = "MM/dd/yyyy"; SimpleDateFormat format = new
		 * SimpleDateFormat(pattern); Date date = format.parse("03/24/2011");
		 * 
		 * Employee employee = new Employee(); employee.setDateOfJoining(date);
		 * employee.setEmpId(1509); employee.setEmpName("balaji");
		 * 
		 * Technology technology1 = new Technology();
		 * technology1.setTechnologyName("java"); Technology technology2 = new
		 * Technology(); technology2.setTechnologyName("adjavced java"); Technology
		 * technology3 = new Technology(); technology3.setTechnologyName("html");
		 * Technology technology4 = new Technology();
		 * technology4.setTechnologyName("css"); Technology technology5 = new
		 * Technology(); technology5.setTechnologyName("hibernate");
		 * 
		 * 
		 * TrainingTrack trainingTrack1 = new TrainingTrack();
		 * trainingTrack1.setTrackName("hybris"); trainingTrack1.setEmployee(employee);
		 * trainingTrack1.getTechnologies().add(technology1);
		 * trainingTrack1.getTechnologies().add(technology2);
		 * trainingTrack1.getTechnologies().add(technology3);
		 * trainingTrack1.getTechnologies().add(technology4);
		 * trainingTrack1.getTechnologies().add(technology5);
		 * trainingTrackDao.save(trainingTrack1);
		 * 
		 * TrainingTrack trainingTrack2 = new TrainingTrack();
		 * trainingTrack2.setTrackName("aem"); trainingTrack2.setEmployee(employee);
		 * trainingTrack2.getTechnologies().add(technology1);
		 * trainingTrack2.getTechnologies().add(technology2);
		 * trainingTrack2.getTechnologies().add(technology3);
		 * trainingTrack2.getTechnologies().add(technology4);
		 * 
		 * trainingTrackDao.save(trainingTrack2);
		 * 
		 * 
		 * 
		 * employee.setTrainingTrack(trainingTrack1);
		 * 
		 * employeeDao.save(employee);
		 */

		/*
		 * Employee employee1 = new Employee(); employee.setDateOfJoining(date);
		 * employee.setEmpId(1506); employee.setEmpName("vishnu");
		 * 
		 * employeeDao.save(employee1);
		 */

	}

	@ResponseBody
	@DeleteMapping("/{id}")
	public void removeEmployee(@PathVariable Long id) {
		employeeService.removeEmployee(id);
	}
	@PostMapping("/update/{id}")
	public EmployeeDto updateEmployee(@PathVariable Long id)  {
		employeeService.updateEmployee(id);
		return null;

	}

	@PutMapping("/update")
	public void updateEmployee(@RequestBody EmployeeDto empdto) throws ParseException {
		employeeService.updateEmployee(empdto);

	}

	@GetMapping("/{id}")
	public void getEmployees(@PathVariable Long id) throws ParseException {
		employeeService.getEmployeeById(id);
	}

	@GetMapping("/{name}")
	public void getEmployees(@PathVariable String name) throws ParseException {
		employeeService.getEmployeeByName(name);

		System.out.println();
	}

	@GetMapping("/all")
	public void getAllEmployees() throws ParseException {
		List<Employee> employeesList = employeeService.getAllEmployees();
		System.out.println(employeesList);
	}

	@GetMapping("/all/{track}")
	public void getAllEmployees(@PathVariable String track) throws ParseException {
		List<Employee> employeesList = employeeService.getAllEmployeesByTrack(track);
		System.out.println(employeesList);
	}
}
