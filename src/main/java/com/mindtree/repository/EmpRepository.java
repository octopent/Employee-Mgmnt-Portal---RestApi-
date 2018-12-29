package com.mindtree.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.model.Employee;

public interface EmpRepository extends CrudRepository<Employee, String>{

}
