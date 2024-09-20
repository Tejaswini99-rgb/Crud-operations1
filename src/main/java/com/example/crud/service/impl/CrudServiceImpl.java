package com.example.crud.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.dto.EmployeeDto;
import com.example.crud.exception.EmployeeNotFoundException;
import com.example.crud.modal.Employee;
import com.example.crud.repository.EmployeeRepo;
import com.example.crud.service.EmployeeService;
@Service
public class CrudServiceImpl implements EmployeeService{
	 @Autowired
	  private EmployeeRepo employeeRepository;

	    @Autowired
	    private ModelMapper modelMapper;
	    // create new employee
	    
	    @Override
	    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
	        Employee employee = modelMapper.map(employeeDto, Employee.class);
	        Employee savedEmployee = employeeRepository.save(employee);
	        return modelMapper.map(savedEmployee, EmployeeDto.class);
	    }
	    
	   //get employee by id
	    @Override
	    public EmployeeDto getEmployeeById(int id) {
	        Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	        return modelMapper.map(employee, EmployeeDto.class);
	    }

	    // get all employees
	    @Override
	    public List<EmployeeDto> getAllEmployees() {
	        return employeeRepository.findAll()
	                .stream()
	                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
	                .collect(Collectors.toList());
	    }

	    //update the employee
	    
	    @Override
	    public EmployeeDto updateEmployee(int id, EmployeeDto employeeDTO) {
	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with" +id));

	        employee.setName(employeeDTO.getName());
	        employee.setDept(employeeDTO.getDept());
	        employee.setJoin_date(employeeDTO.getJoin_date());
	        employee.setSalary(employeeDTO.getSalary());

	        Employee updatedEmployee = employeeRepository.save(employee);
	        return modelMapper.map(updatedEmployee, EmployeeDto.class);
	    }
         
	    //delete the employee
	    @Override
	    public void deleteEmployee(int id) {
	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id "+id));
	        employeeRepository.delete(employee);
	    }
	    
	    
	}



