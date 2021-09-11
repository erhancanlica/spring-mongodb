package com.spring.mongob.service;

import com.spring.mongob.model.Department;
import com.spring.mongob.model.Employee;
import com.spring.mongob.repository.DepartmentRepository;
import com.spring.mongob.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department findById(String departmentID) {
        return departmentRepository.findDepartmentById(departmentID);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteById(String departmentID) {
        departmentRepository.deleteById(departmentID);
    }
}
