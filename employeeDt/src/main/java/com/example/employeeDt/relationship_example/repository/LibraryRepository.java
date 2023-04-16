package com.example.employeeDt.relationship_example.repository;


import com.example.employeeDt.relationship_example.one2one_entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {}

