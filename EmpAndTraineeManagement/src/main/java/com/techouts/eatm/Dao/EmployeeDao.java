package com.techouts.eatm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techouts.eatm.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
