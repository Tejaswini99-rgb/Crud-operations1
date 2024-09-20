package com.example.crud.service;

import java.util.List;
import com.example.crud.dto.EmployeeDto;


public interface EmployeeService {
	
	    EmployeeDto createEmployee(EmployeeDto employeeDto);
	    
	    EmployeeDto getEmployeeById(int id);
	    
	    List<EmployeeDto> getAllEmployees();
	    
	    EmployeeDto updateEmployee(int id, EmployeeDto employeeDTO);
	    
	    void deleteEmployee(int id);

		
	}


