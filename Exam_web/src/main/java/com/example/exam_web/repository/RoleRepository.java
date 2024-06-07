package com.example.exam_web.repository;

import com.example.exam_web.model.Role;
import com.example.exam_web.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleAdmin);

    Role findRoleByUsersIn(Collection<Employee> users);

}