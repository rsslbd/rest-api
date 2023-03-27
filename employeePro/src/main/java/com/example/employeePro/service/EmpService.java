package com.example.employeePro.service;

import com.example.employeePro.entity.Employee;
import com.example.employeePro.repository.Empdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    Empdao dao;

    public void saveEmployee(Employee e){
        dao.save(e);
    }

    public List<Employee> getAll(){


        return dao.getAllEmp();
    }

    public Employee getEmp(Long id) {
        return dao.getSingleEmp(id).orElse(new Employee());
    }

    public void deleteEmpById(Long id) {
        dao.deleteEmp(id);
    }

}
