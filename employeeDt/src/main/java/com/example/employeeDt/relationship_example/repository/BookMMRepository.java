package com.example.employeeDt.relationship_example.repository;


import com.example.employeeDt.relationship_example.many_2_many_entity.BookMM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMMRepository extends JpaRepository<BookMM, Long> { }

