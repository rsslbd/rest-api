package com.example.employeeDt.controller;


import com.example.employeeDt.DTO.ProductDTO;
import com.example.employeeDt.entity.Product;
import com.example.employeeDt.service.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class Controller {
    @Autowired
    Service service;


//    @PostMapping("/emps")
//    public void save(@RequestBody Employee employee){
//        service.save(employee);
//    }
    @PostMapping("/emps")
    public void save(@RequestBody ProductDTO employeeDTO){
        if (employeeDTO != null) {
         Product employee = new Product();
         BeanUtils.copyProperties(employeeDTO ,employee);
            service.save(employee);
        }

    }

//    @PutMapping("/emps")
//    public void update( @RequestBody Employee employee){
//        service.save(employee);
//    }
    @PutMapping("/emps")
    public void update( @RequestBody ProductDTO employeeDTO){
        if (employeeDTO != null) {
            Product employee = new Product();
            BeanUtils.copyProperties(employeeDTO ,employee);
            service.save(employee);
        }

    }

//    @GetMapping("/emps")
//    List<Employee> all() {
//        return service.findAll();
//    }

    @DeleteMapping("/emps/{id}")
    public void delete(@PathVariable("id") Long id){

        service.delete(id);
    }

//    @GetMapping("/emps/{id}")
//    public Employee getById(@PathVariable("id") Long id){
//       return service.getById(id);
//    }

    @GetMapping("/emps/{id}")
    public ProductDTO getByIdDTO(@PathVariable("id") Long id){
        Product employee;
        employee= service.getById(id);
        if (employee.getId() !=null ){
            ProductDTO employeeDTO = new ProductDTO();
            BeanUtils.copyProperties(employee, employeeDTO);
            return employeeDTO;
        }
      return null;
    }
    @GetMapping("/emps")
    List<ProductDTO> all()
    {
       List<Product>  employee =service.findAll();
        List<ProductDTO>  employeeDTO =  new ArrayList<>();
        for (Product emp:employee
             ) {
         ProductDTO empDTO = new ProductDTO();
         BeanUtils.copyProperties(emp, empDTO);
         employeeDTO.add(empDTO);
        }
        return employeeDTO ;
    }


}
