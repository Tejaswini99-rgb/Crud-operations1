package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.dto.EmployeeDto;
import com.example.crud.modal.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	

}
