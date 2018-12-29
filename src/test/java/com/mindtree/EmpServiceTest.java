package com.mindtree;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mindtree.dao.EmpDao;
import com.mindtree.model.Employee;
import com.mindtree.service.EmpService;


public class EmpServiceTest {

	@InjectMocks
	EmpService empservice;
	
	@Mock
	EmpDao empdao;
	
	static List<Employee> dummyEmpList;
	
	@Before
	public void setup(){
		dummyEmpList = new ArrayList<>();
		empservice = new EmpService();
		
		Employee e1 = new Employee(
				"mayank94",
				"abc123",
				"Mayank Kumar",
				"mayank@gmail.com", 
				"14-09-1994",
				"male",
				"What is your pet name?",
				"tommy"
				);
		dummyEmpList.add(e1);
		
		MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testGetAllEmployee() {
		when(empdao.getAllEmployees())
		.thenReturn(dummyEmpList);
		
		assertEquals(dummyEmpList.get(0).getUsername(), 
				empservice.getAllEmployees().get(0).getUsername());
	}
	
	
}
