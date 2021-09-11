package com.spring.mongob.controller;

import com.spring.mongob.model.Department;
import com.spring.mongob.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        List<Department> departments = departmentService.getAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable("id") String departmentID) {
        Department department = departmentService.findById(departmentID);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department department) {
       Department newDepartment = departmentService.save(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Department> update(@RequestBody Department department) {
        Department updateDepartment = departmentService.update(department);
        return new ResponseEntity<>(updateDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String departmentID) {
       departmentService.deleteById(departmentID);
        return ResponseEntity.ok(departmentID);
    }

}
