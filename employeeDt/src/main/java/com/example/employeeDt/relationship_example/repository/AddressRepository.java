package com.example.employeeDt.relationship_example.repository;

import com.example.employeeDt.relationship_example.one2one_entity.Address;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {}
