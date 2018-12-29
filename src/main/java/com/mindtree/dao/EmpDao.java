package com.mindtree.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.model.DTO;
import com.mindtree.model.Employee;
import com.mindtree.repository.EmpRepository;

@Service
public class EmpDao {

	@Autowired
	private EmpRepository empRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		empRepository
		.findAll()
		.forEach(employees::add);
		return employees;
	}

	public Optional<Employee> getEmployee(String username) {
		return empRepository.findById(username);
	}

	public void updateEmployee(Employee employee, String username) {
		empRepository.save(employee);
	}

	public void addEmployee(Employee employee) {
		empRepository.save(employee);
	}

	public void deleteEmployee(String username) {
		empRepository.deleteById(username);
	}

	/*public ResponseEntity<List<Employee>> checkEmp(DTO dto) {

		List<Employee> employees = new ArrayList<>();
		employees = getAllEmployees();
		int flag=0;

		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getUsername().equals(dto.getUsername()) 
					&& employees.get(i).getPassword().equals(dto.getPassword())){
				flag=1;
			}
		}
		if (flag==1) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}
	}*/

	/*public ResponseEntity<List<Employee>> checkEmp(DTO dto) {

		List<Employee> employees = new ArrayList<>();
		employees = getAllEmployees();
		int flag=0;

		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getUsername().equals(dto.getUsername()) 
					&& employees.get(i).getPassword().equals(dto.getPassword())){
				flag=1;
			}
		}
		if (flag==0) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}
	}*/
	
	public String checkEmp(DTO dto) {

		List<Employee> employees = new ArrayList<>();
		employees = getAllEmployees();
		int flag=0;

		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getUsername().equals(dto.getUsername()) 
					&& employees.get(i).getPassword().equals(dto.getPassword())){
				flag=1;
			}
		}
		if (flag==0) {
			return "invalid";
		}
		else {
			return "valid";
		}
	}
}
