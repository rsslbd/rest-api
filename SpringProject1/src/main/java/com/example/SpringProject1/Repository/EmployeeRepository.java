package com.example.SpringProject1.Repository;

import com.example.SpringProject1.Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT u "
            + "FROM Employee u WHERE u.id = ?1")
    Optional<Employee> getUserById(Long id);
}