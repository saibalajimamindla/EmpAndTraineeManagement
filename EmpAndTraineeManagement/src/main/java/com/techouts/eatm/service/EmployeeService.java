package com.techouts.eatm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.eatm.Dao.EmployeeDao;
import com.techouts.eatm.Dao.TrainingTrackDao;
import com.techouts.eatm.converter.EmployeeConvertor;
import com.techouts.eatm.dto.EmployeeDto;
import com.techouts.eatm.model.Employee;
import com.techouts.eatm.model.TrainingTrack;

@Service
public class EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	TrainingTrackDao trainingTrackDao;
	
	@Autowired
	EmployeeConvertor employeeConvertor;

	public void saveEmployee(EmployeeDto dto) {
		if (employeeDao.getByName(dto.getEmpName()) == null) {
			Employee employee = new Employee();
			employee.setEmpId(dto.getEmpId());
			employee.setEmpName(dto.getEmpName());
			String pattern = "MM/dd/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			Date date = null;
			try {
				date = format.parse(dto.getDateOfJoining());
			} catch (ParseException e) {

				e.printStackTrace();
				logger.info("parse exception in employee date of joining");
			}
			employee.setDateOfJoining(date);
			if (dto.getTrainingTrack() != null) {
				employee.setTrainingTrack(trainingTrackDao.getByName(dto.getTrainingTrack()));
			} else {
				employee.setTrainingTrack(trainingTrackDao.getByName("default"));
			}

			employeeDao.save(employee);
		}

	}

	public void removeEmployee(Long id) {
		Employee employee = employeeDao.getByid(id);
		if (employee != null) {
			Long Empid = employee.getEmpId();
			employee.setTrainingTrack(null);
			employeeDao.save(employee);
			employeeDao.deleteById(Empid);
		}

	}
	
	public EmployeeDto updateEmployee(long id) {
		Employee employee = employeeDao.getByid(id);
		if (employee != null) {
			
			return employeeConvertor.modelToDto(employee);
		}
		return null;
	}

	public void updateEmployee(EmployeeDto dto) {
		Employee employee = employeeDao.getByid(dto.getEmpId());
		if (employee != null) {
			employee.setEmpId(dto.getEmpId());
			employee.setEmpName(dto.getEmpName());
			String pattern = "MM/dd/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			Date date = null;
			try {
				date = format.parse(dto.getDateOfJoining());
			} catch (ParseException e) {

				e.printStackTrace();
				logger.info("parse exception in employee date of joining");
			}
			employee.setDateOfJoining(date);
			employee.setTrainingTrack(trainingTrackDao.getByName(dto.getTrainingTrack()));
			employeeDao.save(employee);
		}
	}

	public Employee getEmployeeById(Long id) {
		return employeeDao.getByid(id);
	}

	public Employee getEmployeeByName(String name) {
		return employeeDao.getByName(name);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	public List<Employee> getAllEmployeesByTrack(String track) {
		TrainingTrack trainingTrack = trainingTrackDao.getByName(track);
		System.out.println(trainingTrack);
		List<Employee> employeesList = null;
		if (trainingTrack != null) {

			employeesList = employeeDao.getByTrack(trainingTrack.getId());
		}
		System.out.println(employeesList);
		return employeesList;
	}

}
