package com.fist.project.first_project.dao;

import com.fist.project.first_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
