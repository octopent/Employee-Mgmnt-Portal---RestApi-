package com.mindtree.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.model.DTO;
import com.mindtree.model.Employee;
import com.mindtree.service.EmpService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(method=RequestMethod.POST, value="/EmpMgt/addEmp")
	public void addEmployee(@RequestBody Employee employee) {
		empService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/EmpMgt/deleteEmp/{username}")
	public void deleteEmployee(@PathVariable String username) {
		empService.deleteEmployee(username);
	}
	
	@RequestMapping("/EmpMgt/getAllEmpDetails")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@RequestMapping("EmpMgt/getByEmpId/{username}")
	public Optional<Employee> getEmployee(@PathVariable String username) {
		return empService.getEmployee(username);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/EmpMgt/updateEmp/{username}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String username) {
		empService.updateEmployee(employee,username);
	}
	
	/*@RequestMapping(method=RequestMethod.POST, value="/EmpMgt/checkLogin")
	public ResponseEntity<List<Employee>> checkEmp(@RequestBody DTO dto) {
		return empService.checkEmp(dto);
	}*/
	
	@RequestMapping(method=RequestMethod.POST, value="/EmpMgt/checkLogin")
	public String checkEmp(@RequestBody DTO dto) {
		return empService.checkEmp(dto);
	}
	
}
