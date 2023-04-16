package com.example.employeeDt.repository;


import com.example.employeeDt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
