package com.spring.mongob.seeder;

import com.spring.mongob.model.Department;
import com.spring.mongob.model.Employee;
import com.spring.mongob.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;

    public DbSeeder(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department computing = new Department(
                "1",
                "computing",
                "computing department",
                Arrays.asList(
                        new Employee("1", "Erhan", "Canlıca", "55555", 5, 7500),
                        new Employee("2", "employee", "employee", "444444", 2, 5000))
        );

        Department finance = new Department(
                "2",
                "finance",
                "finance department",
                Arrays.asList(
                        new Employee("1", "employee2", "employee2", "55555", 10, 12000),
                        new Employee("2", "employee3", "employee3", "444444", 1, 4000))
        );

        departmentRepository.deleteAll();
        List<Department> departments = Arrays.asList(computing, finance);
        departmentRepository.saveAll(departments);
    }
}
