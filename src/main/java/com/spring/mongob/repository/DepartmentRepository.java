package com.spring.mongob.repository;

import com.spring.mongob.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository <Department, String> {
    Department findDepartmentById(String departmentID);
}

