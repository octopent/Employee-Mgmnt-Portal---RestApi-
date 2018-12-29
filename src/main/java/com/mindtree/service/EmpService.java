package com.mindtree.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.EmpDao;
import com.mindtree.model.DTO;
import com.mindtree.model.Employee;

@Service
public class EmpService {

	@Autowired
	EmpDao empDao;
	
	public void addEmployee(Employee employee) {
		empDao.addEmployee(employee);
	}

	public void deleteEmployee(String username) {
		empDao.deleteEmployee(username);
	}

	public List<Employee> getAllEmployees() {
		return empDao.getAllEmployees();
	}

	public Optional<Employee> getEmployee(String username) {
		return empDao.getEmployee(username);
	}

	public void updateEmployee(Employee employee, String username) {
		empDao.updateEmployee(employee, username);
	}

	public String checkEmp(DTO dto) {
		return empDao.checkEmp(dto);
	}

}
