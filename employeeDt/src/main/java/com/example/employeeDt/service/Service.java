package com.example.employeeDt.service;


import com.example.employeeDt.entity.Product;
import com.example.employeeDt.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    ProductRepo empRepo;


    public List<Product> findAll() {
        return empRepo.findAll();
    }

    public void save(Product empNew) {
        if (empNew.getId()!= null){
            empRepo.findById(empNew.getId())
                    .map(old -> {

                        old.setName(empNew.getName());

                        old.setQty(empNew.getQty());

                        old.setPrice(empNew.getPrice());
                        old.setBrand(empNew.getBrand());


                        return empRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return empRepo.save(empNew);
                    });
        }else {
            empRepo.save(empNew);
        }
    }

    public Product getById(Long id) {
       return empRepo.findById(id).orElse(new Product());
    }

    public void delete(Long id) {
        empRepo.deleteById(id);
    }

}
