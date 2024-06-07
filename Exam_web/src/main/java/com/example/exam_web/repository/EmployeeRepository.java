package com.example.exam_web.repository;

import com.example.exam_web.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findUserById(Long id);

    Employee findByEmail(String email);
}
