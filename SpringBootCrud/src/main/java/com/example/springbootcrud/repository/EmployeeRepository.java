package com.example.springbootcrud.repository;

import com.example.springbootcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByLastName(String lastName);
    Employee findById(long id);
}
