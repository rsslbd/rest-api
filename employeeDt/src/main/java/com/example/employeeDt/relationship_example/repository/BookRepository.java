package com.example.employeeDt.relationship_example.repository;


import com.example.employeeDt.relationship_example.one_to_many_entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }

